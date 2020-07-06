package com.nx.stategrid.adapter;

import android.content.Context;

import com.nx.stategrid.R;
import com.nx.stategrid.dto.Menu;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseViewHolder;

/**
 * @Auther: luofei
 * @Date: 2020/7/6 16:40
 * @Description:
 */
public class MenuListAdapter extends BaseRecycleViewAdapter<Menu> {

    public MenuListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(BaseViewHolder holder, Menu model, int position) {
        holder.setText(R.id.menu_list_tv, model.getTitle());
        holder.setImageResouse(R.id.menu_list_imv, model.getIcon());

        holder.itemView.setTag(model);
    }
}
