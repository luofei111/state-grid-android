package com.nx.stategrid.weiget.recycleview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;

import com.nx.stategrid.R;


/**
 * Created by luofei on 2016/9/20 0020.
 */
public class BaseRecycleViewGrid extends BaseRecycleView {

    private Context mContext;

    public BaseRecycleViewGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public BaseRecycleViewGrid(Context context) {
        super(context);
        mContext = context;
    }

    public BaseRecycleViewGrid(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }


    public void setColumNum(int columNum, boolean hasDecration) {

        setLayoutManager(new GridLayoutManager(mContext, columNum) {
            // RecyclerView嵌套Scrollview滑动卡顿问题
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        setItemAnimator(new MyRecycleItemAnimator());
        if (hasDecration) {
            addItemDecoration(new DividerGridItemDecoration(mContext, columNum, R.drawable.grid_divider));
        }
    }

    /**
     * 1像素宽度
     * 2020 4 13
     *
     * @param columNum
     * @param hasDecration
     */
   /* public void setColumNum2(int columNum, boolean hasDecration) {

        setLayoutManager(new GridLayoutManager(mContext, columNum) {
            // RecyclerView嵌套Scrollview滑动卡顿问题
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        setItemAnimator(new MyRecycleItemAnimator());
        if (hasDecration) {
            addItemDecoration(new DividerGridItemDecoration(mContext, columNum, R.drawable.grid_divider_d_1));
        }
    }*/
}
