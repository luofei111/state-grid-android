package com.nx.stategrid.weiget.recycleview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by luofei on 2016/9/20 0020.
 */
public class BaseRecycleViewList extends BaseRecycleView {

    LinearLayoutManager linearLayoutManager;

    public BaseRecycleViewList(Context context, AttributeSet attrs) {
        super(context, attrs);
        linearLayoutManager = new LinearLayoutManager(context);
        setLayoutManager(linearLayoutManager);
        setItemAnimator(new MyRecycleItemAnimator());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public BaseRecycleViewList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BaseRecycleViewList(Context context) {
        super(context);
    }


    public void setOrientation(int orientation) {
        linearLayoutManager.setOrientation(orientation);
        setLayoutManager(linearLayoutManager);
    }

    public void addItemDecoration(Context context) {
        addItemDecoration(new RefreshItemDecoration(context, RefreshItemDecoration.VERTICAL_LIST));
    }

    // RecyclerView嵌套Scrollview滑动卡顿问题
    public void setCanScrollVertically(Context context) {
        setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }
}
