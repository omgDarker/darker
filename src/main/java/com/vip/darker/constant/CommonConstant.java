package com.vip.darker.constant;

import com.vip.darker.annotation.BKDefinition;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:27
 * @DateUpdate: 2018/10/17
 * @Description: 普通常量类
 */
public class CommonConstant {

    @BKDefinition(value = "每页条数")
    public static final int PAGE_SIZE = 10;
    @BKDefinition(value = "map初始化容量值")
    public static final int MAP_DEFAULT_INITIAL_CAPACITY = 1 << 4;
    @BKDefinition(value = "响应标识")
    public static final String MSG = "msg";
    @BKDefinition(value = "图片存储路径")
    public static final String IMAGE_PATH = "G://picture";
    @BKDefinition(value = "缓存KEY")
    public static final String REDIS_KEY_ARTICLE = "article";
    @BKDefinition(value = "摘要标签")
    public static final String SUMMARY_LABEL = "<p></p>";
    @BKDefinition(value = "登录密码")
    public static final String LOGIN_PASSWORD = "wangbingan";
}