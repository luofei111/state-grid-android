package com.nx.stategrid.dto;

public class BodyBean {
    /**
     * contentType : header
     * name : 装置基本参数
     * key : 10000
     * value :
     */

    private String contentType;
    private String name;
    private String key;
    private String value;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}