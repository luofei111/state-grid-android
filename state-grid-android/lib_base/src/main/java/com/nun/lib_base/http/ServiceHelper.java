package com.nun.lib_base.http;

import android.util.Log;

import retrofit2.Call;

/**
 * Created by LuoFei on 2018/4/2.
 */

public class ServiceHelper {

    /**
     * 获取单个实体对象
     *
     * @param call
     * @param entityclass 得到的预期结果的对象
     * @param <T>
     */
    public static <T> void callEntity(final Call<BaseResponse> call, final Class<T> entityclass, final OnResonseListener<T> listener, final int actionId) {

        call.enqueue(new RequestCallBack() {

            @Override
            protected void onSucess(String jsonstr) {
                T info = GsonHelper.convertEntity(jsonstr, entityclass);
                if (info == null) {
                    if (listener != null) {
                        listener.onClientError("对象解析失败"+actionId, actionId);
                    }
                } else {
                    if (listener != null) {
                        listener.onSucess(info, actionId);
                    }
                }
                Log.i("startRequest", "返回数据为---->" + jsonstr);
            }

            @Override
            protected void onError(String errorCode, String errormsg) {
                listener.onServerError(errorCode, errormsg, actionId);
                Log.i("startRequest", "接口请求失败---->" + errormsg + "(" + actionId + ")");
            }
        });
    }
}
