package com.nx.stategrid.presenter;

import com.nun.lib_base.mvp.BasePresent;
import com.nx.stategrid.view.TemplateManagerView;

/**
 * @Auther: luofei
 * @Date: 2020/7/6 16:23
 * @Description:
 */
public class TemplateManagerPresenter extends BasePresent<TemplateManagerView> {
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
