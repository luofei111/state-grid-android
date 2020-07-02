package com.nun.lib_base.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigProgress;
import com.mylhyl.circledialog.params.ProgressParams;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import butterknife.ButterKnife;

/**
 * Created by luofei on 2017/7/3 0003.
 */

public abstract class MvpActivity<V, P extends BasePresent<V>> extends FragmentActivity implements CommonTitleBar.OnTitleBarListener {

    protected P presenter;

    protected DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        presenter = initPresenter();
        presenter.attach((V) this);
        initData();
    }

    @SuppressLint("SourceLockedOrientationActivity")
    public void inflateLayout(int layoutID) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(layoutID);
        ButterKnife.bind(this);
    }

    public void showProcessDialog(String content) {
        if (!isFinishing()) {
            dialogFragment = new CircleDialog.Builder()
                    .setCanceledOnTouchOutside(true)
                    .setCancelable(true)
                    .setWidth(0.6f)
                    .setProgressText(content)
                    .configProgress(new ConfigProgress() {
                        @Override
                        public void onConfig(ProgressParams params) {
                            params.indeterminateColor = Color.parseColor("#1e6ff6");
                        }
                    })
                    .setProgressStyle(ProgressParams.STYLE_SPINNER)
                    .show(getSupportFragmentManager());
        }
    }

    public void showProcessCanCancleDialog(String content) {
        if (!isFinishing()) {
            dialogFragment = new CircleDialog.Builder()
                    .setCanceledOnTouchOutside(false)
                    .setCancelable(true)
                    .setWidth(0.6f)
                    .setProgressText(content)
                    .configProgress(new ConfigProgress() {
                        @Override
                        public void onConfig(ProgressParams params) {
                            params.indeterminateColor = Color.parseColor("#1e6ff6");
                        }
                    })
                    .setProgressStyle(ProgressParams.STYLE_SPINNER)
                    .show(getSupportFragmentManager());
        }
    }

    public void closeProcessDialog() {
        if (null != dialogFragment) {
            dialogFragment.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stopRequest();
        presenter.detach();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract P initPresenter();

    public void toActivity(Activity activity, Class c) {
        startActivity(new Intent(activity, c));
    }
}
