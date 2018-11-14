package com.vip.darker.model;

import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/11/13 17:03
 * @Description: 结果集实体类
 */
public class ResultModel {

    private int code;// 操作码
    private String msg;// 操作信息
    private Map<String, Object> result;// 操作结果集

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
