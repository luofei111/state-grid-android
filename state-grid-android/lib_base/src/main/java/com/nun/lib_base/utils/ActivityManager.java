package com.nun.lib_base.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/12.
 */

public class ActivityManager {
    private static ActivityManager mActivityManager;
    private List<Activity> mActivities=new ArrayList<Activity>();
    //构造方法私有化，采用单例模式
    private ActivityManager(){}

    public static ActivityManager getInstance(){
        if(mActivityManager==null){
            mActivityManager=new ActivityManager();
        }
        return mActivityManager;
    }

    //添加activity
    public void addActivity(Activity activity){
        mActivities.add(activity);
    }
    //移除activity
    public void removeActivity(Activity activity){
        mActivities.remove(activity);
    }
    //将activity全部关闭掉
    public void clear(){
        for(Activity activity:mActivities){
            activity.finish();
        }
    }

    public void toLogin(Activity contentActivity){
        for(Activity activity:mActivities){
            if (!activity.getPackageName().equals(contentActivity)) {
                activity.finish();
            }
        }

    }
}
