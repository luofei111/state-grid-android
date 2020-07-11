package com.nx.stategrid.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.MenuListAdapter;
import com.nx.stategrid.dto.Menu;
import com.nx.stategrid.presenter.MainPresenter;
import com.nx.stategrid.view.MainView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewGrid;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.main_menu_grid)
    BaseRecycleViewGrid mainMenuGrid;

    @Override
    public void initView() {
        inflateLayout(R.layout.activity_main_layout);
        mainMenuGrid.setColumNum(4, false);
    }

    @Override
    public void initData() {
        MenuListAdapter adapter = new MenuListAdapter(this, R.layout.menu_list_item_layout);
        mainMenuGrid.setAdapter(adapter);
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("", "", getResources().getString(R.string.template_manager), R.mipmap.mune_modle_icon));
        menus.add(new Menu("", "", getResources().getString(R.string.commit_record), R.mipmap.menu_history_icon));
        adapter.setData(menus);

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(ViewGroup parent, View v, int position) {

                Menu model = (Menu) v.getTag();
                switch (model.getTitle()) {

                    case "模板管理":
                        startActivity(new Intent(MainActivity.this, TemplateManagerActivity.class));
                        break;

                    case "提交记录":
                        startActivity(new Intent(MainActivity.this, RecordListActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
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
