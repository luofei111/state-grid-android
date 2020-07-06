package com.nx.stategrid.presenter;

import com.nun.lib_base.mvp.BasePresent;
import com.nx.stategrid.dto.QuestionInfo;
import com.nx.stategrid.view.QuestionView;

import java.util.Map;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:13
 * @Description:
 */
public class QuestionPresenter extends BasePresent<QuestionView> {

    @Override
    public void startRequest(Class c, String path, Map<String, String> params, String requestType, int actionId) {
        super.startRequest(c, path, params, requestType, actionId);
    }

    @Override
    public void onRequestSucess(Object info, int actionId) {
        switch (actionId) {
            case 1:
                view.setQuestionInfo((QuestionInfo) info);
                break;
        }
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
