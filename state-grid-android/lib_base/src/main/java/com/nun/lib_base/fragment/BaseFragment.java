package com.nun.lib_base.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.github.nukc.stateview.StateView;

import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigProgress;
import com.mylhyl.circledialog.params.ProgressParams;
import com.nun.lib_base.R;
import com.nun.lib_base.controller.BaseController;
import com.nun.lib_base.controller.IModeChangeListener;


/**
 * Created by lenovo on 2017/4/26.
 */

public abstract class BaseFragment extends Fragment implements
        IModeChangeListener {

    protected BaseController mController;

    protected DialogFragment dialogFragment;
    protected StateView mStateView;
    private AlertDialog dialog;

    protected void setmStateView(StateView mStateView) {
        this.mStateView = mStateView;
    }

    protected Handler mHandler = new Handler() {

        @Override
        public void handleMessage(android.os.Message msg) {
            handlerMessage(msg);
        }

    };

    protected void init() {
        // default Empty implementn
    }

    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mActivity = activity;
    }


    protected void showProcessDialog(String content) {
        if (!getMyActivity().isFinishing()) {
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
                    .show(getActivity().getSupportFragmentManager());
        }
    }

    protected void closeProcessDialog() {
        if (null != dialogFragment) {
            dialogFragment.dismiss();
        }
    }


    //得到可靠地Activity
    public Activity getMyActivity() {
        return mActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    protected void closeSafeCheckDialog() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }

    protected void handlerMessage(Message msg) {
        // default Empty implementn
    }

    protected void initController() {
        // default Empty implementn
    }


    public void onRefresh() {

    }

    @Override
    public void onModeChanged(int action, Object... values) {
        mHandler.obtainMessage(action, values[0]).sendToTarget();
    }

    protected String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    public void tip(String tipStr) {
        Toast.makeText(getMyActivity(), tipStr, Toast.LENGTH_LONG).show();
    }

    /*
    protected void toChatView(String groupid, String chatTitle, String messageType, String custom, String url, String getCustomMessageList) {
        Intent customIntent = new Intent(getMyActivity(), ChatActivity.class);
        customIntent.putExtra(ChatActivity.CHAT_TITLE, chatTitle);
        customIntent.putExtra(ChatActivity.GROUP_ID, groupid);
        customIntent.putExtra(messageType, custom);
        customIntent.putExtra(url, getCustomMessageList);
        startActivity(customIntent);
    }
    */

    protected void undo() {
        tip("正在研发中....");
    }


    protected void showLoading() {
        if (mStateView == null) {
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


    protected void retryLoading() {
    }

    protected void showEmpty() {
        if (mStateView == null) {
            return;
        }
        mStateView.showEmpty();
    }

    protected void showContent() {
        if (mStateView == null) {
            return;
        }
        mStateView.showContent();
    }

    protected void showRetry() {
        if (mStateView == null) {
            return;
        }
        mStateView.showRetry();
    }


}

