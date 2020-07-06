package com.nx.stategrid.app;

import android.app.Application;

import com.nun.lib_base.utils.Utils;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 8:58
 * @Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}

