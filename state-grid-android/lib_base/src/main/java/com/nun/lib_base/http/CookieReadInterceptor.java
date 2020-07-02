package com.nun.lib_base.http;

import com.nun.lib_base.utils.SPUtils;
import com.nun.lib_base.utils.Utils;
import com.nun.lib_base.utils.date.Constants;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//cookie 读取拦截器
public class CookieReadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        HashSet<String> stringSet = (HashSet<String>) SPUtils.get(Utils.getApp(), Constants.COOKIE, new HashSet<String>());

        if (stringSet != null) {
            for (String cookie : stringSet) {
                builder.addHeader("Cookie", cookie);
            }
        }

        return chain.proceed(builder.build());
    }
}