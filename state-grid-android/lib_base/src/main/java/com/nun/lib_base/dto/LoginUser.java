package com.nun.lib_base.dto;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/6/15.
 */
@Table(name = "loginuser")
public class LoginUser implements Serializable {
    /*    @Column(name = "dbId", isId = true)
        private int dbId;*/
    @Column(name = "name")
    private String name;
    @Column(name = "id", isId = true)
    private String id;
    @Column(name = "seesionId")
    private String seesionId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "userImage")
    private String userImage;
    @Column(name = "userImage")
    private String userType;
    @Column(name = "userCode")
    private String userCode;
    @Column(name = "yingyuanId")
    private String yingyuanId;
    @Column(name = "yingyuanCode")
    private String yingyuanCode;
    @Column(name = "departName")
    private String departName;//所属公司
    @Column(name = "customGroupId")
    private Integer customGroupId;//客户讨论组ID
    @Column(name = "stuffGroupId")
    private Integer stuffGroupId;//员工讨论区ID
    @Column(name = "topOrgCode")
    private String topOrgCode;
    @Column(name = "topOrgId")
    private String topOrgId;
    @Column(name = "sex")
    private String sex; //性别
    @Column(name = "birthday")
    private String birthday; //生日
    @Column(name = "recommandCode")
    private String recommandCode; //邀请码
    @Column(name = "address")
    private String address; //地址
    @Column(name = "position")
    private String position;//职位
    private String realNameStatus;//实名制
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }



    public String getRealNameStatus() {
        return realNameStatus;
    }

    public void setRealNameStatus(String realNameStatus) {
        this.realNameStatus = realNameStatus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private List<Depart> departList;
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRecommandCode() {
        return recommandCode;
    }

    public void setRecommandCode(String recommandCode) {
        this.recommandCode = recommandCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getTopOrgId() {
        return topOrgId;
    }

    public void setTopOrgId(String topOrgId) {
        this.topOrgId = topOrgId;
    }

    public String getTopOrgCode() {
        return topOrgCode;
    }

    public void setTopOrgCode(String topOrgCode) {
        this.topOrgCode = topOrgCode;
    }

    public Integer getCustomGroupId() {
        return customGroupId;
    }

    public void setCustomGroupId(Integer customGroupId) {
        this.customGroupId = customGroupId;
    }

    public Integer getStuffGroupId() {
        return stuffGroupId;
    }

    public void setStuffGroupId(Integer stuffGroupId) {
        this.stuffGroupId = stuffGroupId;
    }



    public List<Depart> getDepartList() {
        return departList;
    }

    public void setDepartList(List<Depart> departList) {
        this.departList = departList;
    }

    public LoginUser() {

    }

    public LoginUser(String name, String id, String seesionId, String phone, String userImage) {
        this.name = name;
        this.id = id;
        this.seesionId = seesionId;
        this.phone = phone;
        this.userImage = userImage;
    }


    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getYingyuanId() {
        return yingyuanId;
    }

    public void setYingyuanId(String yingyuanId) {
        this.yingyuanId = yingyuanId;
    }

    public String getYingyuanCode() {
        return yingyuanCode;
    }

    public void setYingyuanCode(String yingyuanCode) {
        this.yingyuanCode = yingyuanCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeesionId() {
        return seesionId;
    }

    public void setSeesionId(String seesionId) {
        this.seesionId = seesionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }


}
