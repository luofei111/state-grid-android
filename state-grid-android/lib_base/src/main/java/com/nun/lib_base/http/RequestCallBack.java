package com.nun.lib_base.http;

import com.nun.lib_base.utils.StringUtils;
import com.nun.lib_base.utils.date.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LuoFei on 2018/4/2.
 */

public abstract class RequestCallBack implements Callback<BaseResponse> {

    @Override
    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
        if (response.isSuccessful()) {
//            HeaderInterceptor.cookie = response.headers().get("set-cookie");
            BaseResponse baseResponse = response.body();
            handleMsg(baseResponse);
        } else {
            onError(Constants.RES_ERROR_CODE, "网络请求失败,请重试(" + response.raw().code() + ")");
        }
    }

    @Override
    public void onFailure(Call<BaseResponse> call, Throwable t) {
        // onError(RES_FAIL_CODE, "请求异常,请重试");
        onError(Constants.RES_FAIL_CODE, t.getMessage());
    }

    private void handleMsg(BaseResponse baseResponse) {
        boolean success = baseResponse.isSuccess();
        String retMsg = baseResponse.getMessage();

        if (success) {
            // 请求成功
            onSucess(GsonHelper.objectToJSONString(baseResponse));
        } else {
            // 请求失败
            onError(success + "", retMsg);
        }
    }

    protected abstract void onSucess(String jsonstr);

    protected abstract void onError(String errorCode, String errormsg);
}
