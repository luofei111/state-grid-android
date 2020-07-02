package com.nun.lib_base.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;

import com.github.nukc.stateview.StateView;
import com.gyf.barlibrary.ImmersionBar;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigProgress;
import com.mylhyl.circledialog.params.ProgressParams;
import com.nun.lib_base.R;
import com.nun.lib_base.controller.BaseController;
import com.nun.lib_base.controller.IModeChangeListener;
import com.nun.lib_base.utils.ActivityManager;
import com.nun.lib_base.utils.NullUtils;
import com.nun.lib_base.utils.SPUtils;
import com.nun.lib_base.utils.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseActivity extends AppCompatActivity implements IModeChangeListener {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    public static final String USER_INFO = "USER_INFO";
    private static final String TAG = "yfw.BaseActivity";
    protected BaseController mController;
    protected StateView mStateView;
    protected DialogFragment dialogFragment;
    private ImmersionBar mImmersionBar;
    private AlertDialog dialog;
    private static List<String> noFullWindowActivity = new ArrayList<>();
    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    };

    protected void handlerMessage(Message msg) {

    }

    protected void closeSafeCheckDialog() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }

    /*protected void callPhone(String phone) {
        if (NullUtils.isEmpty(phone)) {
            tip("手机号码不能为空");
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                Toast.makeText(this, "请授权！", Toast.LENGTH_LONG).show();
                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent permissionIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                permissionIntent.setData(uri);
                startActivity(permissionIntent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri phoneData = Uri.parse("tel:" + phone);
            intent.setData(phoneData);
            startActivity(intent);
        }
    }*/

    protected void showProcessDialog(String content) {
        if (isFinishing()) {
            dialogFragment = new CircleDialog.Builder()
                    .setCanceledOnTouchOutside(false)
                    .setCancelable(true)
                    .setWidth(0.6f)
                    .setProgressText(content)
                    .configProgress(new ConfigProgress() {
                        @Override
                        public void onConfig(ProgressParams params) {
                            params.indeterminateColor = Color.parseColor("#E9AD44");
                        }
                    })
                    .setProgressStyle(ProgressParams.STYLE_SPINNER)
                    .show(getSupportFragmentManager());
        }
    }


    protected void closeProcessDialog() {
        if (null != dialogFragment) {
            dialogFragment.dismiss();
        }
    }

    protected void initController() {
        //default showEmpty implemention
    }

    protected void initTitleBar() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        noFullWindowActivity.add("SplashActivity");
        noFullWindowActivity.add("LucklyPersonActivity");
        noFullWindowActivity.add("LucklyHistoryActivity");
        noFullWindowActivity.add("LucklyGroupActivity");
        noFullWindowActivity.add("LucklyConditionActivity");
        //修改状态栏颜色
        Log.d(TAG, "当前启动的Activity名称为: " + getClass().getSimpleName());
        if (!noFullWindowActivity.contains(getClass().getSimpleName())) {
            //applyKitKatTranslucency();
        } else {
            //  mImmersionBar = ImmersionBar.with(this);
            //   mImmersionBar.statusBarColor(R.color.title_bar_color).fitsSystemWindows(true).init();
        }
    }


    protected void setStatusBarColor(int statusBarColor) {
        if (mImmersionBar != null) {
            mImmersionBar.statusBarColor(statusBarColor);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mImmersionBar) {
            mImmersionBar.destroy();
        }
        //DialogSettings.unloadAllDialog();           //卸载掉所有对话框
    }

    protected void init() {
        //default impelemention
    }

    public void finishAll() {
        SPUtils.remove(this, USER_INFO);
        ActivityManager.getInstance().clear();
    }

    public void tip(String tipStr) {
        Toast.makeText(this, tipStr, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onModeChanged(int action, Object... values) {
        mHandler.obtainMessage(action, values[0]).sendToTarget();
    }

    protected boolean ifValueWasEmpty(String... values) {
        for (String value : values) {
            if (StringUtils.isEmpty(value)) {
                return true;
            }
        }
        return false;
    }


    protected void undo() {
        tip("正在研发....");
    }

    protected void unrearch() {
        tip("暂未开放....");
    }


    protected void showLoading() {
        if (!isFinishing()) {
            if (null == mStateView) {
                return;
            }
            mStateView.showLoading();
            mStateView.setEmptyResource(R.layout.view_empty);
            mStateView.setRetryResource(R.layout.view_retry);
            mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
                @Override
                public void onRetryClick() {
                    //do something, no need to call showLoading()
                    //不需要调用showLoading()方法, StateView自会调用
                    retryLoading();
                }
            });
        }

    }

    protected void retryLoading() {
    }

    protected void showEmpty() {
        if (null == mStateView) {
            return;
        }
        mStateView.showEmpty();
    }

    protected void showContent() {
        if (null == mStateView) {
            return;
        }
        mStateView.showContent();
    }

    protected void showRetry() {
        if (null == mStateView) {
            return;
        }
        mStateView.showRetry();
    }

    protected void showRetry(String type) {
        if (null == mStateView) {
            return;
        }
        mStateView.showRetry();
    }

/*    protected void startWebView(String title, String URL) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WebViewActivity.TITLE_NAME, title);
        intent.putExtra(WebViewActivity.URL, URL);
        startActivity(intent);
    }*/

    protected Dialog showBottomDialog(@LayoutRes int resId, Context context) {
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(context, R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(context, resId, null);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        return dialog;
    }
}
