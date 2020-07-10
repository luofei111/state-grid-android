package com.nx.stategrid.view;

import com.nun.lib_base.http.BaseResponse;
import com.nun.lib_base.mvp.BaseView;

/**
 * @Auther: luofei
 * @Date: 2020/7/7 11:24
 * @Description:
 */
public interface CommitRecordView extends BaseView {

    void setUploadResult(BaseResponse baseResponse);
}
