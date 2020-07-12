package com.nx.stategrid.presenter;

import com.nun.lib_base.http.BaseResponse;
import com.nun.lib_base.mvp.BasePresent;
import com.nx.stategrid.view.CommitRecordView;

import java.util.Map;

/**
 * @Auther: luofei
 * @Date: 2020/7/7 11:25
 * @Description:
 */
public class CommitRecordPresenter extends BasePresent<CommitRecordView> {

    @Override
    public void sentRequest(Class c, String path, Object object, int actionId) {
        view.showProgress();
        super.sentRequest(c, path, object, actionId);
    }

    @Override
    public void onRequestSucess(Object info, int actionId) {
        view.hideProgress();
        switch (actionId) {
            case 1:
                view.setUploadResult((BaseResponse) info);
                break;
        }

    }

    @Override
    public void onRequestClientError(String errorMsg, int actionId) {
        view.onError(errorMsg);
        view.hideProgress();
    }

    @Override
    public void onNetWorkError(String errorMsg) {
        view.onError(errorMsg);
        view.hideProgress();
    }

    @Override
    public void onRequestServerError(String errorCode, String errorMsg, int actionId) {
        view.onError(errorMsg);
        view.hideProgress();
    }

    @Override
    public void stopRequest() {

    }
}
