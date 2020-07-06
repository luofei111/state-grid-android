package com.nx.stategrid;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.nun.lib_base.mvp.MvpActivity;
import com.nun.lib_base.mvp.MvpFragment;
import com.nx.stategrid.adapter.MenuListAdapter;
import com.nx.stategrid.dto.Menu;
import com.nx.stategrid.presenter.TemplateManagerPresenter;
import com.nx.stategrid.view.TemplateManagerView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewGrid;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Auther: luofei
 * @Date: 2020/7/6 16:22
 * @Description:
 */
public class TemplateManagerActivity extends MvpActivity<TemplateManagerView, TemplateManagerPresenter> implements TemplateManagerView {

    @BindView(R.id.template_manager_tb)
    CommonTitleBar titleBar;

    @BindView(R.id.template_manager_grid)
    BaseRecycleViewGrid templateManagerGrid;

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_template_manager_layout);
        titleBar.setListener(this);

        templateManagerGrid.setColumNum(4, false);
    }

    @Override
    public void initData() {
        MenuListAdapter adapter = new MenuListAdapter(this, R.layout.menu_list_item_layout);
        templateManagerGrid.setAdapter(adapter);
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(getResources().getString(R.string.template1), R.mipmap.add_group_icon));
        menus.add(new Menu(getResources().getString(R.string.template2), R.mipmap.add_group_icon));
        adapter.setData(menus);

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(ViewGroup parent, View v, int position) {

                Menu menu = (Menu) v.getTag();
                startActivity(new Intent(TemplateManagerActivity.this, QuestionActivity.class)
                        .putExtra("title", menu.getTitle()));
            }
        });
    }

    @Override
    public TemplateManagerPresenter initPresenter() {
        return new TemplateManagerPresenter();
    }

    @Override
    public void onClicked(View v, int action, String extra) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void toast(CharSequence s) {

    }

    @Override
    public void toast(int id) {

    }

    @Override
    public void showNullLayout() {

    }

    @Override
    public void hideNullLayout() {

    }

    @Override
    public void showErrorLayout(View.OnClickListener listener) {

    }

    @Override
    public void hideErrorLayout() {

    }

    @Override
    public void onError(String errorInfo) {

    }
}
