package com.nun.lib_base.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * Created by luofei on 2017/8/19 0019.
 */

public abstract class MvpFragment<V, P extends BasePresent<V>> extends Fragment {

    protected P presenter;

    private View view;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        presenter = initPresenter();
        presenter.attach((V) this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        presenter.detach();
        super.onDestroyView();
    }

    public abstract P initPresenter();

    public abstract View initView(LayoutInflater inflater);

    public abstract void initData();
}
