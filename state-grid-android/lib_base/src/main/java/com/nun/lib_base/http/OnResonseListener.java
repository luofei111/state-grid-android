package com.nun.lib_base.http;

/**
 * Created by LuoFei on 2018/4/2.
 * 数据返回监听
 */

public interface OnResonseListener<T> {

    void onSucess(T info, int actionId);

    void onClientError(String errorMsg, int actionId);

    void onServerError(String errorCode, String errorMsg, int actionId);
}
