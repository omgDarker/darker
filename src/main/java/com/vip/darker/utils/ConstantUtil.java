package com.vip.darker.utils;

import com.vip.darker.annotation.BKDefinition;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:27
 * @DateUpdate: 2018/10/17
 * @Description: 常量类
 */
public class ConstantUtil {

    @BKDefinition(value = "每页条数")
    public static final int PAGE_SIZE = 10;
    @BKDefinition(value = "响应标识")
    public static final String MSG = "msg";
    @BKDefinition(value = "图片存储路径")
    public static final String IMAGE_PATH = "G://picture";
    @BKDefinition(value = "缓存KEY")
    public static final String REDIS_KEY_ARTICLE = "article";
}