package com.nun.lib_base.dto;

/**
 * 部门信息表
 */
public class Depart {
    private String departId; //公司编号
    private String departName; //公司名称
    private String topDepartCode; //顶级组织机构编码
    private Integer stuffGroupId; //员工讨论区编号
    private Integer customGroupId; //用户讨论区编号
    private String topDepartId;//顶级组织架构编号


    public String getTopDepartId() {
        return topDepartId;
    }

    public void setTopDepartId(String topDepartId) {
        this.topDepartId = topDepartId;
    }

    public String getTopDepartCode() {
        return topDepartCode;
    }

    public void setTopDepartCode(String topDepartCode) {
        this.topDepartCode = topDepartCode;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getStuffGroupId() {
        return stuffGroupId;
    }

    public void setStuffGroupId(Integer stuffGroupId) {
        this.stuffGroupId = stuffGroupId;
    }

    public Integer getCustomGroupId() {
        return customGroupId;
    }

    public void setCustomGroupId(Integer customGroupId) {
        this.customGroupId = customGroupId;
    }
}
