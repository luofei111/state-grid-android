package com.nx.stategrid.ui;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigButton;
import com.mylhyl.circledialog.callback.ConfigItems;
import com.mylhyl.circledialog.callback.ConfigTitle;
import com.mylhyl.circledialog.params.ButtonParams;
import com.mylhyl.circledialog.params.CloseParams;
import com.mylhyl.circledialog.params.ItemsParams;
import com.mylhyl.circledialog.params.TitleParams;
import com.mylhyl.circledialog.res.values.CircleColor;
import com.mylhyl.circledialog.view.listener.OnLvItemClickListener;
import com.nun.lib_base.mvp.MvpFragment;
import com.nun.lib_base.utils.SPUtils;
import com.nun.lib_base.utils.ToastUtils;
import com.nun.lib_base.utils.date.DateUtil;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.QuestionListAdapter;
import com.nx.stategrid.dto.BodyBean;
import com.nx.stategrid.dto.CommitRecord;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.presenter.QuestionPresenter;
import com.nx.stategrid.utils.AssetsUtils;
import com.nx.stategrid.utils.Constans;
import com.nx.stategrid.view.QuestionView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewList;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:17
 * @Description:
 */
public class QuestionFragment extends MvpFragment<QuestionView, QuestionPresenter> implements QuestionView, QuestionListAdapter.OprateCallBack {

    @BindView(R.id.questioninfo_title_tv)
    TextView titleTv;

    @BindView(R.id.question_list)
    BaseRecycleViewList questionRecycleList;

    private List<BodyBean> data;

    private QuestionListAdapter adapter;

    private Map<String, String> paramsMap;

    private String title;

    private int homeLength;

    private String reportId;

    private boolean isReport;

    public QuestionFragment(List<BodyBean> data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHomeLength(int homeLength) {
        this.homeLength = homeLength;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public void setReport(boolean report) {
        isReport = report;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_questioninfo_layout, null);
        return view;
    }

    @Override
    public void initData() {
        titleTv.setText(title);
        paramsMap = new HashMap<>();
        adapter = new QuestionListAdapter(getActivity(), data);
        adapter.setOprateCallBack(this);
        // adapter.setReport(isReport);
        questionRecycleList.setAdapter(adapter);
    }

    @OnClick({R.id.commit_report_tv})
    public void myOnclciK(View view) {
        switch (view.getId()) {
            case R.id.commit_report_tv:

                List<BodyBean> homeData = adapter.getDate().subList(0, homeLength);
                List<BodyBean> bodyData = adapter.getDate().subList(homeLength, adapter.getDate().size());

                // String questionInfoJson = (String) SPUtils.get(getActivity(), reportId, "");

                // QuestionInfo questionInfo = new Gson().fromJson(questionInfoJson, QuestionInfo.class);

                // ?

                QuestionInfo questionInfo;
                if (Constans.reportId1.equals(reportId)){
                    questionInfo = new Gson().fromJson(AssetsUtils.getJsonStr(getActivity(), "templatefile1"), QuestionInfo.class);
                }else {
                    questionInfo = new Gson().fromJson(AssetsUtils.getJsonStr(getActivity(), "templatefile2"), QuestionInfo.class);
                }

                questionInfo.getData().getContent().setHome(homeData);

                questionInfo.getData().getContent().setBody(bodyData);

                // 保存提交记录（reportId）
                String questionInfoStr = new Gson().toJson(questionInfo);
                SPUtils.put(getActivity(), questionInfo.getData().getReportId(), questionInfoStr);

                CommitRecord commitRecord = new CommitRecord();
                commitRecord.setReportId(questionInfo.getData().getReportId());
                commitRecord.setReportTitle(questionInfo.getData().getReportName());
                commitRecord.setReportTime(DateUtil.getDateCn(new Date()));
                for (BodyBean homeDatum : homeData) {
                    if ("stationName".equals(homeDatum.getKey())) {
                        commitRecord.setReportPerson(homeDatum.getValue());
                    }
                    if ("00002".equals(homeDatum.getKey())) {
                        commitRecord.setReportDevice(homeDatum.getValue());
                    }
                    if ("00001".equals(homeDatum.getKey())) {
                        commitRecord.setReportStation(homeDatum.getValue());
                    }
                }

                String commitRecordStr = new Gson().toJson(commitRecord);
                SPUtils.put(getActivity(), questionInfo.getData().getReportId() + "-overview", commitRecordStr);
                getActivity().setResult(200);
                getActivity().finish();
                break;
        }
    }

    @Override
    public void mathSelectCallBack(int position) {
        List<String> items = new ArrayList<>();
        items.add("√");
        items.add("×");
        showSelectDialog(items, position);
    }

    @Override
    public void nomalSelectCallBack(int position) {
        List<String> items = new ArrayList<>();
        items.add("正确");
        items.add("错误");
        showSelectDialog(items, position);
    }

    private void showSelectDialog(List<String> items, int position) {
        new CircleDialog.Builder()
                .setGravity(Gravity.CENTER)
                .setTitle("请选择正确或错误")
                .setWidth(0.8f)
                .configPositive(new ConfigButton() {
                    @Override
                    public void onConfig(ButtonParams params) {
                        params.textSize = 18;
                        params.topMargin = 0;
                    }
                })
                .setPositive("取消", view -> {

                }).configItems(new ConfigItems() {
            @Override
            public void onConfig(ItemsParams params) {
                params.textColor = Color.parseColor("#3993e9");
                params.textSize = 18;
            }
        }).setItems(items, new OnLvItemClickListener() {
            @Override
            public boolean onItemClick(AdapterView<?> parent, View view, int mPosition, long id) {
                data.get(position).setValue(items.get(mPosition));
                adapter.notifyDataSetChanged();
                paramsMap.put(data.get(position).getKey(), data.get(position).getValue());
                return true;
            }
        }).show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void onClicked(View v, int action, String extra) {

    }

    @Override
    public QuestionPresenter initPresenter() {
        return new QuestionPresenter();
    }

    @Override
    public void setQuestionInfo(QuestionInfo questionInfo) {

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
