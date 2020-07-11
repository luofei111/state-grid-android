package com.nx.stategrid.adapter;

import android.content.Context;
import android.view.View;

import com.nx.stategrid.R;
import com.nx.stategrid.dto.CommitRecord;
import com.nx.stategrid.weiget.recycleview.BaseRecycleViewAdapter;
import com.nx.stategrid.weiget.recycleview.BaseViewHolder;

/**
 * @Auther: luofei
 * @Date: 2020/7/8 10:37
 * @Description:
 */
public class CommitRecordListAdapter extends BaseRecycleViewAdapter<CommitRecord> {

    private CommitRecordCallBack commitRecordCallBack;

    public void setCommitRecordCallBack(CommitRecordCallBack commitRecordCallBack) {
        this.commitRecordCallBack = commitRecordCallBack;
    }

    public CommitRecordListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(BaseViewHolder holder, CommitRecord model, int position) {
        holder.setText(R.id.report_title_tv, model.getReportTitle());
        holder.setText(R.id.report_time_tv, model.getReportTime());
        holder.setText(R.id.report_person_tv, "提交人：" + model.getReportPerson());
        holder.setText(R.id.report_device_tv, "设备名称：" + model.getReportDevice());
        holder.setText(R.id.report_station_tv, "站名：" + model.getReportStation());

        if (model.getStatus() == 1) {
            // 已上传
            holder.setViewVisiable(R.id.report_upload_tv, View.INVISIBLE);
        } else {
            // 未上传
            holder.setViewVisiable(R.id.report_upload_tv, View.VISIBLE);
        }

        holder.setOnClickListener(R.id.report_upload_tv, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitRecordCallBack.reportUpload(model, position);
            }
        });

        holder.itemView.setTag(model);
    }

    public interface CommitRecordCallBack {
        void reportUpload(CommitRecord model, int position);
    }
}
