package com.nx.stategrid;

import android.content.Intent;
import android.view.View;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.presenter.MainPresenter;
import com.nx.stategrid.view.MainView;

import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_main_layout);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.commit_report_tv})
    public void myOnclick(View view) {
        switch (view.getId()) {
            case R.id.commit_report_tv:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
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
