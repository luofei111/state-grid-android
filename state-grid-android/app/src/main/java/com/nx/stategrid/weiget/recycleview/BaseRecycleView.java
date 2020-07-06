package com.nx.stategrid.weiget.recycleview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by luofei on 2016/9/20 0020.
 */
public abstract class BaseRecycleView extends RecyclerView {


    public BaseRecycleView(Context context) {
        super(context);
    }

    public BaseRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
