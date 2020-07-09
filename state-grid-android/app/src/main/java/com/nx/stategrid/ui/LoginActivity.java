package com.nx.stategrid.ui;

import android.view.View;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.R;
import com.nx.stategrid.presenter.LoginPresenter;
import com.nx.stategrid.view.LoginView;

/**
 * @Auther: luofei
 * @Date: 2020/7/2 17:50
 * @Description:
 */
public class LoginActivity extends MvpActivity<LoginView, LoginPresenter> implements LoginView {

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_login_layout);
    }


    @Override
    public void initData() {

    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
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
