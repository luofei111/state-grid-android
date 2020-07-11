package com.nx.stategrid.dto;

import java.util.Comparator;

/**
 * @Auther: luofei
 * @Date: 2020/7/8 10:38
 * @Description:
 */
public class CommitRecord implements Comparator<CommitRecord> {

    private String templateId;
    private String reportId;
    private String reportTitle;
    private String reportTime;
    private String reportDevice;
    private String reportPerson;
    private String reportStation;
    private int status;
    private long createDate;

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportDevice() {
        return reportDevice;
    }

    public void setReportDevice(String reportDevice) {
        this.reportDevice = reportDevice;
    }

    public String getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }

    public String getReportStation() {
        return reportStation;
    }

    public void setReportStation(String reportStation) {
        this.reportStation = reportStation;
    }


    @Override
    public int compare(CommitRecord commitRecord, CommitRecord t1) {
        if (commitRecord.getCreateDate() > t1.getCreateDate()) {
            return -1;
        } else if (commitRecord.getCreateDate() < t1.getCreateDate()) {
            return 1;
        } else {
            return 0;
        }
    }
}
