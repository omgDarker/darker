package com.vip.darker.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/25 18:19
 * @Description: 处理消息工具类
 */
public class PrintMsg {

    // 200表示成功,100表示失败
    private int code;
    // 提示信息
    private String msg;
    // 用户返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<>();

    public static PrintMsg success() {
        PrintMsg result = new PrintMsg();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    public static PrintMsg fail() {
        PrintMsg result = new PrintMsg();
        result.setCode(100);
        result.setMsg("处理失败");
        return result;
    }

    public PrintMsg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    private Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
