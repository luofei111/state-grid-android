package com.nx.stategrid.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigButton;
import com.mylhyl.circledialog.params.ButtonParams;
import com.nun.lib_base.http.BaseResponse;
import com.nun.lib_base.mvp.MvpActivity;
import com.nun.lib_base.utils.SPUtils;
import com.nun.lib_base.utils.StringUtils;
import com.nun.lib_base.utils.ToastUtils;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.CommitRecordListAdapter;
import com.nx.stategrid.dto.CommitRecord;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.presenter.CommitRecordPresenter;
import com.nx.stategrid.utils.Constans;
import com.nx.stategrid.view.CommitRecordView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;

/**
 * @Auther: luofei
 * @Date: 2020/7/7 11:24
 * @Description:
 */
public class RecordListActivity extends MvpActivity<CommitRecordView, CommitRecordPresenter> implements CommitRecordView, CommitRecordListAdapter.CommitRecordCallBack {

    @BindView(R.id.commit_record_list)
    BaseRecycleViewList commitRecordRecycle;

    private CommitRecordListAdapter adapter;

    private String uploadUrl = "genContract";

    private CommitRecord mCommitRecord;

    private int mPosition;

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_commit_record_layout);
    }

    @Override
    public void initData() {
        adapter = new CommitRecordListAdapter(this, R.layout.commit_record_list_item_layout);
        commitRecordRecycle.setAdapter(adapter);
        adapter.setCommitRecordCallBack(this);

        adapter.setData(getCommitRecord());

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(ViewGroup parent, View v, int position) {

                CommitRecord commitRecord = (CommitRecord) v.getTag();
                startActivityForResult(new Intent(RecordListActivity.this, QuestionActivity.class)
                        .putExtra("title", commitRecord.getReportTitle())
                        .putExtra("isReport", true)
                        .putExtra("templateId", commitRecord.getTemplateId())
                        .putExtra("reportId", commitRecord.getReportId()), 100);
            }
        });

    }

    @Override
    public void reportUpload(CommitRecord model, int position) {

        mCommitRecord = model;

        mPosition = position;

        QuestionInfo questionInfo = new Gson().fromJson((String) SPUtils.get(RecordListActivity.this, model.getReportId(), ""), QuestionInfo.class);

        presenter.sentRequest(BaseResponse.class, uploadUrl, questionInfo.getData(), 1);
    }

    @Override
    public void setUploadResult(BaseResponse uploadResult) {
        new CircleDialog.Builder()
                .setWidth(0.8f)
                .setText("上传成功")
                .setPositive("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .configPositive(new ConfigButton() {
                    @Override
                    public void onConfig(ButtonParams params) {
                        params.textSize = 16;
                        params.topMargin = 0;
                    }
                })
                .show(getSupportFragmentManager());

        // 更新SP数据
        List<CommitRecord> commitRecords = getCommitRecord();
        for (CommitRecord record : commitRecords) {
            if (record.getReportId().equals(mCommitRecord.getReportId())) {
                record.setStatus(1);
                String commitRecordStr = new Gson().toJson(record);
                SPUtils.put(this, record.getReportId() + Constans.reportList, commitRecordStr);
            }
        }
        adapter.setData(commitRecords);
        adapter.notifyDataSetChanged();
    }

    public List<CommitRecord> getCommitRecord() {
        List<CommitRecord> commitRecords = new ArrayList<>();

        HashSet<String> reportSet = (HashSet<String>) SPUtils.get(this, Constans.reportIds, new HashSet<String>());
        if (reportSet != null) {
            for (String reportId : reportSet) {
                String commmitRecordStr = (String) SPUtils.get(this, reportId + Constans.reportList, "");
                if (!StringUtils.isEmpty(commmitRecordStr)) {
                    commitRecords.add(new Gson().fromJson(commmitRecordStr, CommitRecord.class));
                }
            }
        }

        Collections.sort(commitRecords, new CommitRecord());

        return commitRecords;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            adapter.setData(getCommitRecord());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public CommitRecordPresenter initPresenter() {
        return new CommitRecordPresenter();
    }

    @Override
    public void onClicked(View v, int action, String extra) {
        switch (action) {

        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void toast(CharSequence s) {
        ToastUtils.showShort(s);
    }

    @Override
    public void toast(int id) {
        ToastUtils.showShort(id);
    }

    @Override
    public void showNullLayout() {

    }

    @Override
    public void hideNullLayout() {

    }

    @Override
    public void showErrorLayout(View.OnClickListener listener) {

    }

    @Override
    public void hideErrorLayout() {

    }

    @Override
    public void onError(String errorInfo) {
        toast(errorInfo);
    }
}
