package com.vip.darker.constant;

import com.vip.darker.annotation.BKDefinition;

/**
 * @Auther: Darker
 * @Date: 2019/02/14 15:58
 * @Description: HTTP协议常量类
 */
public class HttpConstant {

    @BKDefinition(value = "查询请求")
    public static final String METHOD_GET = "GET";
    @BKDefinition(value = "新增请求")
    public static final String METHOD_POST = "POST";
    @BKDefinition(value = "更新请求")
    public static final String METHOD_PUT = "PUT";
    @BKDefinition(value = "删除请求")
    public static final String METHOD_DELETE = "DELETE";
    @BKDefinition(value = "主机IP")
    public static final String HOST_IP = "10.155.52.112";
    @BKDefinition(value = "本地IP")
    public static final String LOCAL_IP = "127.0.0.1";
    @BKDefinition(value = "本地IP")
    public static final String LOCAL_SECOND_IP = "0:0:0:0:0:0:0:1";
}