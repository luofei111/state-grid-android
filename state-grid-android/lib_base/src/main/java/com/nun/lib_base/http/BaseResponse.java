package com.nun.lib_base.http;

import java.io.Serializable;

/**
 * Created by LuoFei on 2018/4/2.
 */

public class BaseResponse<T> implements Serializable {

    private boolean success;
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
