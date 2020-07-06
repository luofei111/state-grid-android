package com.nx.stategrid;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

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
import com.nun.lib_base.utils.ToastUtils;
import com.nx.stategrid.adapter.QuestionListAdapter;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.presenter.QuestionPresenter;
import com.nx.stategrid.view.QuestionView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewList;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
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

    private List<QuestionInfo.DataBean.ContentBean.BodyBean> data;

    private QuestionListAdapter adapter;

    private Map<String, String> paramsMap;

    private String title;

    public QuestionFragment(List<QuestionInfo.DataBean.ContentBean.BodyBean> data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
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
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new QuestionListAdapter(getActivity(), data);
        adapter.setOprateCallBack(this);
        questionRecycleList.setAdapter(adapter);
    }

    @OnClick({R.id.commit_report_tv})
    public void myOnclciK(View view) {
        switch (view.getId()) {
            case R.id.commit_report_tv:

                toast("修改：“" + paramsMap.size());

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
                        params.textSize = 14;
                        params.topMargin = 0;
                    }
                })
                .setPositive("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).configItems(new ConfigItems() {
            @Override
            public void onConfig(ItemsParams params) {
                params.textColor = Color.parseColor("#3993e9");
                params.textSize = 12;
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
