package com.nx.stategrid.ui;

import android.view.View;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.R;
import com.nx.stategrid.presenter.SplashPresenter;
import com.nx.stategrid.view.SplashView;

/**
 * @Auther: luofei
 * @Date: 2020/7/2 17:25
 * @Description:
 */
public class SplashActivity extends MvpActivity<SplashView, SplashPresenter> implements SplashView {

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_splash_layout);
    }

    @Override
    public void initData() {

    }

    @Override
    public SplashPresenter initPresenter() {
        return new SplashPresenter();
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
