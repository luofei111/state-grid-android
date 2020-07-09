package com.nx.stategrid.dto;

/**
 * @Auther: luofei
 * @Date: 2020/7/8 10:38
 * @Description:
 */
public class CommitRecord {

    private String reportId;
    private String reportTitle;
    private String reportTime;
    private String reportDevice;
    private String reportPerson;
    private String reportStation;

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
}
