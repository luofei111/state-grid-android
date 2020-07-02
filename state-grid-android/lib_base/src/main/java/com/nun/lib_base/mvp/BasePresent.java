package com.nun.lib_base.mvp;

import android.util.Log;

import com.google.gson.Gson;
import com.nun.lib_base.http.BaseResponse;
import com.nun.lib_base.http.InitRetrofit;
import com.nun.lib_base.http.OnResonseListener;
import com.nun.lib_base.http.RetrofitSerives;
import com.nun.lib_base.http.ServiceHelper;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import static com.nun.lib_base.http.NetWorkBaseUrl.ROOT_URl;

/**
 * Created by luofei on 2017/7/3 0003.
 */

public abstract class BasePresent<T> {

    public RetrofitSerives requestSerives;

    public Call<BaseResponse> call;

    public T view;

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        //this.view = null;
    }

    public void startRequest(Class c, final String path, Map<String, String> params, String requestType, int actionId) {

        requestSerives = InitRetrofit.getInstance().getRetrofit(ROOT_URl);

        Log.i("startRequest", "请求接口为：---->" + ROOT_URl + path);
        Log.i("startRequest", "请求参数为：---->" + new Gson().toJson(params));

        if (requestSerives != null) {
            switch (requestType) {
                case "GET":
                    // get请求
                    call = requestSerives.getResponseInfoByGet(path, params);
                    break;

                case "POST":
                    // post请求
                    call = requestSerives.getResponseInfo(path, params);
                    break;

                case "Body":
                    // RequestBody请求
                    call = requestSerives.getResponseInfoWithBody(path, generateRequestBody(params));
                    break;
            }
            ServiceHelper.callEntity(call, c, new OnResonseListener<Object>() {

                @Override
                public void onSucess(Object info, int actionId) {
                    onRequestSucess(info, actionId);
                }

                @Override
                public void onClientError(String errorMsg, int actionId) {
                    onRequestClientError(errorMsg, actionId);
                }

                @Override
                public void onServerError(String errorCode, String errorMsg, int actionId) {
                    onRequestServerError(errorCode, errorMsg, actionId);
                }
            }, actionId);
        } else {
            onNetWorkError("您的网络已断开，请检查");
        }
    }

    private static Map<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : requestDataMap.keySet()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),
                    requestDataMap.get(key) == null ? "" : requestDataMap.get(key));
            requestBodyMap.put(key, requestBody);
        }
        return requestBodyMap;
    }

    public abstract void onRequestSucess(Object info, int actionId);

    public abstract void onRequestClientError(String errorMsg, int actionId);

    public abstract void onNetWorkError(String errorMsg);

    public abstract void onRequestServerError(String errorCode, String errorMsg, int actionId);

    public abstract void stopRequest();
}
