package com.nun.lib_base.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by lenovo on 2017/6/12.
 */

public abstract class BaseActionBarActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        int menuLayout = setMenuLayout();
        inflater.inflate(menuLayout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 设置menu布局文件
     *
     * @return
     */
    protected abstract int setMenuLayout();

}
