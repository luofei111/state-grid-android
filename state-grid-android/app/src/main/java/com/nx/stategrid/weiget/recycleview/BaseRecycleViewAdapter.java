package com.nx.stategrid.weiget.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by luofei on 2016/9/19 0019.
 */
public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    public int layoutId;
    private OnItemClickListener onItemClickListener;//单击事件
    private OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识
    public Context mContext;
    public List<T> mData = null;

    public BaseRecycleViewAdapter(Context context, int layoutId) {
        this.mContext = context;
        this.layoutId = layoutId;
    }

    public void setData(List<T> data) {
        this.mData = data;
    }


    public void addData(List<T> datas){
        mData.addAll(datas);
        notifyDataSetChanged();
    }
    @Override
    public BaseViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        View v = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        final BaseViewHolder holder = new BaseViewHolder(v, mContext);
        //单击事件回调
        v.setOnClickListener(v1 -> {
            if (clickFlag) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(parent, v1, holder.getLayoutPosition());
                }
            }
            clickFlag = true;
        });
        //单击长按事件回调
        v.setOnLongClickListener(v12 -> {
            if (onItemLongClickListner != null) {
                onItemLongClickListner.onItemLongClickListner(parent, v12, holder.getLayoutPosition());
            }
            clickFlag = false;
            return false;
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, getItem(position), position);
    }

    /**
     * 获取指定索引位置的数据模型
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return mData.get(position);
    }

    protected abstract void convert(BaseViewHolder holder, T model, int position);


    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public interface OnItemClickListener {
        void onItemClickListener(ViewGroup parent, View v, int position);
    }

    public interface OnItemLongClickListner {
        void onItemLongClickListner(ViewGroup parent, View v, int position);
    }


}
