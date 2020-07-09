package com.nun.lib_base.http;

import android.util.Log;

import com.google.gson.Gson;

import okhttp3.RequestBody;

/**
 * Created by LuoFei on 2018/4/2.
 */

public class HTTPUtils {

    /**
     * 将封装好的请求bean，转化为requestBody,用于传递json格式的参数
     *
     * @param url    本次请求的地址，用于打印请求参数日志
     * @param object
     * @return
     */
    public static RequestBody getRequestBody(String url, Object object) {
        Gson gson = new Gson();
        String jsonParams = gson.toJson(object);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonParams);
        return body;
    }
}
