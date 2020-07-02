package com.nun.lib_base.http;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by LuoFei on 2018/3/20.
 */

public interface RetrofitSerives {

    @POST("{path}")
    Call<BaseResponse> getResponseInfo(@Path(value = "path", encoded = true) String path, @QueryMap Map<String, String> queryParams);

    @GET("{path}")
    Call<BaseResponse> getResponseInfoByGet(@Path(value = "path", encoded = true) String path, @QueryMap Map<String, String> queryParams);


    @Multipart
    @POST("{path}")
    Call<BaseResponse> getResponseInfoWithBody(@Path(value = "path", encoded = true) String path, @PartMap Map<String, RequestBody> requestBodyMap);

}
