package com.nun.lib_base.controller;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import org.xutils.common.util.LogUtil;

/**
 * Created by lenovo on 2017/7/24.
 */

public abstract class BaseController {

    protected IModeChangeListener modeChangeListener;
    protected Context mContext;
    protected MaterialDialog dialog;

    public BaseController(Context m) {
        this.mContext = m;
    }

    public void setModeChangeListener(IModeChangeListener listener) {
        modeChangeListener = listener;
    }


    /**
     * 一个页面可能有多个网路请求
     *
     * @param action
     * @param data   请求数据
     */
    public void sendAsyncMessage(final int action, final Object... data) {
        Thread messageThread = new Thread() {
            @Override
            public void run() {
                handleMessage(action, data);
            }
        };
        messageThread.start();
        LogUtil.d("线程结束");
    }


    /**
     * 子类实现具体的业务代码
     *
     * @param action
     * @param values
     */
    protected abstract void handleMessage(int action, Object... values);
}
