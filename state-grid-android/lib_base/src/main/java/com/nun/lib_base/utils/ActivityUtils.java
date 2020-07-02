package com.nun.lib_base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;


import com.nun.lib_base.activity.BaseActivity;

import java.io.Serializable;
import java.util.Map;


/**
 * Created by lenovo on 2017/7/24.
 */

public class ActivityUtils {


    public static void startActivity(Context context, Class<? extends BaseActivity> clazz, boolean isFinishSelf) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
        if (isFinishSelf) {
            ((Activity) context).finish();
        }
    }

    public static void startActivityForResult(Context context, Class<? extends BaseActivity> clazz, boolean isFinishSelf,int REQUESTCODE) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        ((BaseActivity)context).startActivityForResult(intent,REQUESTCODE);
        if (isFinishSelf) {
            ((Activity) context).finish();
        }
    }
    public static void delayStartActivity(final Context context, final Class<? extends BaseActivity> clazz, final boolean isFinishSelf, int delay) {
        new Handler(new Handler.Callback() {
            //处理接收到的消息的方法
            @Override
            public boolean handleMessage(Message arg0) {
                //实现页面跳转
                startActivity(context, clazz, isFinishSelf);
                return false;
            }
        }).sendEmptyMessageDelayed(0, delay); //表示延时三秒进行任务的执行
    }
    public static void startActivityWithData(Context context, Class<? extends BaseActivity> clazz, Map<String, Object> data, boolean isFinishSelf) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        if (!NullUtils.isEmpty(data)) {
            for (String key : data.keySet()) {
                Object value = data.get(key);
                System.out.println("key= " + key + " and value= " + value);
                if (value instanceof String) {
                    intent.putExtra(key, value + "");
                }
                if (value instanceof Integer) {
                    intent.putExtra(key, (int) value);
                }
                if (value instanceof Long) {
                    intent.putExtra(key, (long) value);
                }
                if (value instanceof Float) {
                    intent.putExtra(key, (float)value);
                }
                if(value instanceof Serializable){
                    intent.putExtra(key,(Serializable)value);
                }
            }
        }
        context.startActivity(intent);
        if (isFinishSelf) {
            ((Activity) context).finish();
        }
    }
    public static void startActivityWithDataForResult(Context context, Class<? extends BaseActivity> clazz, Map<String, Object> data, boolean isFinishSelf,int REQUESTCODE) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        if (!NullUtils.isEmpty(data)) {
            for (String key : data.keySet()) {
                Object value = data.get(key);
                System.out.println("key= " + key + " and value= " + value);
                if (value instanceof String) {
                    intent.putExtra(key, value + "");
                }
                if (value instanceof Integer) {
                    intent.putExtra(key, (int) value);
                }
                if (value instanceof Long) {
                    intent.putExtra(key, (long) value);
                }
                if (value instanceof Float) {
                    intent.putExtra(key, (float)value);
                }
                if(value instanceof Serializable){
                    intent.putExtra(key,(Serializable)value);
                }
            }
        }
        ((BaseActivity)context).startActivityForResult(intent, REQUESTCODE);
        if (isFinishSelf) {
            ((Activity) context).finish();
        }
    }

    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper wrapper = (ContextWrapper) context;
            return findActivity(wrapper.getBaseContext());
        } else {
            return null;
        }
    }

}
