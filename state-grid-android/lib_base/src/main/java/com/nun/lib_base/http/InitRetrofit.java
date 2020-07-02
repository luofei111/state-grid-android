package com.nun.lib_base.http;

import com.nun.lib_base.utils.NetworkUtils;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by luofei on 2017/1/5 0005.
 */

public class InitRetrofit {

    private static InitRetrofit initRetrofit;
    private Retrofit retrofit;
    private RetrofitSerives requestSerives;
    private static final int DEFAULT_TIMEOUT = 5000;//5

    private OkHttpClient sClient = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();

    public static InitRetrofit getInstance() {
        if (initRetrofit == null) {
            initRetrofit = new InitRetrofit();
        }
        return initRetrofit;
    }

    /**
     * 初始化Retrofit
     */
    public RetrofitSerives getRetrofit(String baseIp) {

        if (NetworkUtils.isConnected()) {
            // 网络诊断
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseIp)
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())   //增加返回值为String的支持
                    .addConverterFactory(GsonConverterFactory.create())  //增加返回值为Gson的支持(以实体类返回)
                    // 增加返回值为Oservable<T>的支持
                    //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            requestSerives = retrofit.create(RetrofitSerives.class);  //这里采用的是Java的动态代理模式

            return requestSerives;
        } else {
            return null;
        }
    }

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("Connection", "close").build();
                    return chain.proceed(request);
                }
            })
            .addInterceptor(new CookieReadInterceptor())
            .addInterceptor(new CookieSaveInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            // 忽略https认证
            .sslSocketFactory(getSSLSocketFactory())
            .hostnameVerifier(getHostnameVerifier())
            .build();

    // 忽略htts认证
    //获取这个SSLSocketFactory
    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取TrustManager
    private static TrustManager[] getTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        }};
        return trustAllCerts;
    }


    //获取HostnameVerifier
    public static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        return hostnameVerifier;
    }

}