package com.nun.lib_base.http;

import java.io.Serializable;

/**
 * Created by LuoFei on 2018/4/2.
 */

public class BaseResponse<T> implements Serializable {

    //private boolean success;
    //private String message;

    private String msg;
    private Integer code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
