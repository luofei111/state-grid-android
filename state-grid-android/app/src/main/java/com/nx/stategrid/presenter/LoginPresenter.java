package com.nx.stategrid.presenter;

import com.nun.lib_base.http.BaseResponse;
import com.nun.lib_base.mvp.BasePresent;
import com.nx.stategrid.view.LoginView;

import java.util.Map;

/**
 * @Auther: luofei
 * @Date: 2020/7/2 17:51
 * @Description:
 */
public class LoginPresenter extends BasePresent<LoginView> {

    @Override
    public void startRequest(Class c, String path, Map<String, String> params, String requestType, int actionId) {
        super.startRequest(c, path, params, requestType, actionId);
    }

    @Override
    public void onRequestSucess(Object info, int actionId) {

    }

    @Override
    public void onRequestClientError(String errorMsg, int actionId) {

    }

    @Override
    public void onNetWorkError(String errorMsg) {

    }

    @Override
    public void onRequestServerError(String errorCode, String errorMsg, int actionId) {

    }

    @Override
    public void stopRequest() {

    }
}
