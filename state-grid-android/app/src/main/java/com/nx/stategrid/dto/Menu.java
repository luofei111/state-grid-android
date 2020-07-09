package com.nx.stategrid.dto;

/**
 * @Auther: luofei
 * @Date: 2020/7/6 16:40
 * @Description:
 */
public class Menu {
    private String reportId;
    private String title;
    private int icon;

    public Menu(String reportId, String title, int icon) {
        this.reportId = reportId;
        this.title = title;
        this.icon = icon;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
