package com.vip.darker.vo;

import com.vip.darker.annotation.BKDefinition;

import java.util.Map;

@BKDefinition(value = "表现对象")
public class ResultVO {

    @BKDefinition(value = "操作码")
    private Integer code;
    @BKDefinition(value = "操作信息")
    private String msg;
    @BKDefinition(value = "结果集")
    private Map<String, Object> result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}