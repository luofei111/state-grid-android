package com.nx.stategrid;

import android.view.View;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.presenter.LoginPresenter;
import com.nx.stategrid.view.LoginView;

/**
 * @Auther: luofei
 * @Date: 2020/7/2 17:50
 * @Description:
 */
public class LoginActivity extends MvpActivity<LoginView, LoginPresenter> {

    @Override
    public void initView() {

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
}
