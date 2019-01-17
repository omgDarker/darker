package com.vip.darker.elasticsearch.entity;

import com.vip.darker.annotation.BKDefinition;

import java.io.Serializable;

@BKDefinition(value = "数据传输对象")
public class QueryParamDTO implements Serializable {

    private static final long serialVersionUID = 5486321522251477289L;

    @BKDefinition(value = "检索字段")
    private String key;
    @BKDefinition(value = "检索值")
    private Object val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}