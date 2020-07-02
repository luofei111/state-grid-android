package com.nun.lib_base.http;

import java.io.Serializable;

/**
 * Created by LuoFei on 2018/4/2.
 */

public class BaseRequest<T> implements Serializable {

    private T reqbody;

    public T getReqbody() {
        return reqbody;
    }

    public void setReqbody(T reqbody) {
        this.reqbody = reqbody;
    }

    public BaseRequest(T reqbody) {
        this.reqbody = reqbody;
    }
}
