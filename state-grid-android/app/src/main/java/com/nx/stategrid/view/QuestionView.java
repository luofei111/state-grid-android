package com.nx.stategrid.view;

import com.nun.lib_base.mvp.BaseView;
import com.nx.stategrid.dto.QuestionInfo;

/**
 * @Auther: luofei
 * @Date: 2020/7/3 13:13
 * @Description:
 */
public interface QuestionView extends BaseView {

    void  setQuestionInfo(QuestionInfo questionInfo);
}

