package com.nx.stategrid.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
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
                        .putExtra("reportId", commitRecord.getReportId()), 100);
            }
        });

    }

    @Override
    public void reportUpload(CommitRecord model) {

        QuestionInfo questionInfo = new Gson().fromJson((String) SPUtils.get(RecordListActivity.this, model.getReportId(), ""), QuestionInfo.class);

        presenter.sentRequest(BaseResponse.class, uploadUrl, questionInfo.getData(), 1);
    }

    @Override
    public void setUploadResult() {
        toast("上传成功");
    }

    public List<CommitRecord> getCommitRecord() {
        List<CommitRecord> commitRecords = new ArrayList<>();

        List<String> reportIds = new ArrayList<>();
        reportIds.add(Constans.reportId1 + "-overview");
        reportIds.add(Constans.reportId2 + "-overview");

        for (String reportId : reportIds) {
            String commmitRecordStr = (String) SPUtils.get(this, reportId, "");
            if (!StringUtils.isEmpty(commmitRecordStr)) {
                commitRecords.add(new Gson().fromJson(commmitRecordStr, CommitRecord.class));
            }
        }

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

    }
}
