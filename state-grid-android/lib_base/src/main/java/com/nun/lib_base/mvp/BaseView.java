package com.nun.lib_base.mvp;

import android.view.View;

/**
 * Created by luofei on 2017/7/3 0003.
 */

public interface BaseView {

    /**
     * 显示loading框
     */
    void showProgress();

    /**
     * 隐藏loading框
     */
    void hideProgress();

    void toast(CharSequence s);

    void toast(int id);

    /**
     * 显示空数据布局
     */
    void showNullLayout();

    /**
     * 隐藏空数据布局
     */
    void hideNullLayout();

    /**
     * 显示异常布局
     *
     * @param listener
     */
    void showErrorLayout(View.OnClickListener listener);

    void hideErrorLayout();

    void onError(String errorInfo);

}
