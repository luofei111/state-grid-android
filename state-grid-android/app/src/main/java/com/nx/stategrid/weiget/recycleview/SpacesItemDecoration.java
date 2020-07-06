package com.nx.stategrid.weiget.recycleview;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @Auther: luofei
 * @Date: 2019/4/26 14:24
 * @Description:
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int horizatal;
    private int vertial;

    public SpacesItemDecoration(int horizatal, int vertial) {
        this.horizatal = horizatal;
        this.vertial = vertial;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = horizatal;
        outRect.right = horizatal;
       // outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
       /* if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }*/
    }


}