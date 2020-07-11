package com.nx.stategrid.ui;

import android.view.View;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.nun.lib_base.mvp.MvpActivity;
import com.nun.lib_base.utils.SPUtils;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.MyViewPagerAdapter;
import com.nx.stategrid.dto.BodyBean;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.presenter.QuestionPresenter;
import com.nx.stategrid.utils.AssetsUtils;
import com.nx.stategrid.utils.Constans;
import com.nx.stategrid.view.QuestionView;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:12
 * @Description:
 */
public class QuestionActivity extends MvpActivity<QuestionView, QuestionPresenter> implements QuestionView {

    /*@BindView(R.id.question_vp)
    ViewPager viewPager;*/

    @BindView(R.id.fragment_continer)
    FrameLayout fragmentContiner;

    MyViewPagerAdapter adapter;

    private String url = "test";

    private List<Fragment> fragments;

    private String title;

    private boolean isReport;

    private String reportId;

    private String templateId;

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_questioninfo_layout);
    }

    @Override
    public void initData() {
        title = getIntent().getStringExtra("title");
        reportId = getIntent().getStringExtra("reportId");
        templateId = getIntent().getStringExtra("templateId");
        isReport = getIntent().getBooleanExtra("isReport", false);
        // Map<String, String> params = new HashMap<>();
        // presenter.startRequest(QuestionInfo.class, url, params, "GET", 1);
        // fragments = new ArrayList<>();

        QuestionInfo questionInfo = null;
        if (isReport) {
            questionInfo = new Gson().fromJson((String) SPUtils.get(QuestionActivity.this, reportId, ""), QuestionInfo.class);
        } else {
            if (Constans.templateId1.equals(templateId)){
                questionInfo = new Gson().fromJson(AssetsUtils.getJsonStr(this, "templatefile1"), QuestionInfo.class);
            }else {
                questionInfo = new Gson().fromJson(AssetsUtils.getJsonStr(this, "templatefile2"), QuestionInfo.class);
            }
        }
        setQuestionInfo(questionInfo);
    }

    @Override
    public void setQuestionInfo(QuestionInfo questionInfo) {
        List<BodyBean> homeData = questionInfo.getData().getContent().getHome();
        int homeLenth = homeData.size();
        List<BodyBean> bodyData = questionInfo.getData().getContent().getBody();

        homeData.addAll(bodyData);

        QuestionFragment questionFragment = new QuestionFragment(homeData);

        //questionFragment.setTitle(title);
        questionFragment.setmQuestionInfo(questionInfo);
        questionFragment.setHomeLength(homeLenth);
        //questionFragment.setReportId(questionInfo.getData().getReportId());
        questionFragment.setReport(isReport);
        //questionFragment.setTemplateId(templateId);

        //fragments.add(questionFragment);

        //adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
        //viewPager.setAdapter(adapter);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_continer, questionFragment)
                .commit();
    }

    @Override
    public QuestionPresenter initPresenter() {
        return new QuestionPresenter();
    }

    @Override
    public void onClicked(View v, int action, String extra) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void toast(CharSequence s) {

    }

    @Override
    public void toast(int id) {

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
