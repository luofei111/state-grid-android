package com.nx.stategrid.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.nun.lib_base.mvp.MvpActivity;
import com.nx.stategrid.R;
import com.nx.stategrid.adapter.MenuListAdapter;
import com.nx.stategrid.dto.Menu;
import com.nx.stategrid.presenter.TemplateManagerPresenter;
import com.nx.stategrid.utils.CommUtils;
import com.nx.stategrid.utils.Constans;
import com.nx.stategrid.view.TemplateManagerView;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewGrid;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
        List<Menu> menus = CommUtils.getMenus(this);
        adapter.setData(menus);

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(ViewGroup parent, View v, int position) {
                if (position == 0 || position == 1) {
                    Menu menu = (Menu) v.getTag();
                    startActivityForResult(new Intent(TemplateManagerActivity.this, QuestionActivity.class)
                            .putExtra("title", menu.getTitle())
                            .putExtra("isReport", false)
                            .putExtra("templateId", menu.getTemplateId())
                            .putExtra("reportId", menu.getReportId()), 100);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            startActivity(new Intent(this, RecordListActivity.class));
            finish();
        }
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
