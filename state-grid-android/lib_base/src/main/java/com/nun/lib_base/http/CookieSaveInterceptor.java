package com.nun.lib_base.http;

import com.nun.lib_base.utils.SPUtils;
import com.nun.lib_base.utils.Utils;
import com.nun.lib_base.utils.date.Constants;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

//存储Cookie拦截器
public class CookieSaveInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            SPUtils.put(Utils.getApp(), Constants.COOKIE, cookies);

        }
        return originalResponse;
    }
}