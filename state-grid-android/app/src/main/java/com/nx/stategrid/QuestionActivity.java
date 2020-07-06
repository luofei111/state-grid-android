package com.nx.stategrid;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.nun.lib_base.mvp.MvpActivity;
import com.nun.lib_base.utils.NetworkUtils;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.MyViewPagerAdapter;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.presenter.QuestionPresenter;
import com.nx.stategrid.view.QuestionView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:12
 * @Description:
 */
public class QuestionActivity extends MvpActivity<QuestionView, QuestionPresenter> implements QuestionView {

    @BindView(R.id.question_vp)
    ViewPager viewPager;

    MyViewPagerAdapter adapter;

    private String url = "test";

    private List<Fragment> fragments;

    private String title;

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_questioninfo_layout);

    }

    @Override
    public void initData() {
        title = getIntent().getStringExtra("title");

        Map<String, String> params = new HashMap<>();
        presenter.startRequest(QuestionInfo.class, url, params, "GET", 1);
        fragments = new ArrayList<>();
    }

    @Override
    public void setQuestionInfo(QuestionInfo questionInfo) {
        List<QuestionInfo.DataBean.ContentBean.BodyBean> data = questionInfo.getData().getContent().getBody();

        QuestionFragment questionFragment = new QuestionFragment(data);
        questionFragment.setTitle(title);
        fragments.add(questionFragment);

        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

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
