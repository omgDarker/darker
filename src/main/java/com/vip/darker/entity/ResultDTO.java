package com.vip.darker.entity;

import com.vip.darker.annotation.BKDefinition;

import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/11/13 17:03
 * @Description: 数据传输对象
 */
@BKDefinition(value = "DTO")
public class ResultDTO {

    @BKDefinition(value = "操作码")
    private int code;
    @BKDefinition(value = "操作信息")
    private String msg;
    @BKDefinition(value = "结果集")
    private Map<String, Object> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}