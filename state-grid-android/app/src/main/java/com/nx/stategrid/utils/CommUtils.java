package com.nx.stategrid.utils;

import android.content.Context;

import com.nx.stategrid.R;
import com.nx.stategrid.dto.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: luofei
 * @Date: 2020/7/13 9:57
 * @Description:
 */
public class CommUtils {


    private static String[] templateIds = {Constans.templateId1, Constans.templateId2, Constans.templateId3, Constans.templateId4,
            Constans.templateId5};

    private static Integer[] titles = {R.string.template_title1, R.string.template_title2, R.string.template_title3, R.string.template_title4,
            R.string.template_title5};

    public static List<Menu> getMenus(Context context) {
        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < templateIds.length; i++) {
            menus.add(new Menu(templateIds[i], "", context.getResources().getString(titles[i]), R.mipmap.modle_icon));
        }
        return menus;
    }
}
