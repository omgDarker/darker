package com.vip.darker.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 工具类
 * @date: 2020/11/16 5:21 下午
 * @version: v1.0.0
 */
@Slf4j
public class CommonUtil {

    /**
     * @description: 判断是否是linux操作系统
     * @param: []
     * @return: boolean
     * @auther: wangbingan[www.wangbingan.com]
     * @date: 2020/11/17 11:25 上午
     **/
    public static boolean isLinux() {
        // Mac OS X
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        return os != null && os.toLowerCase().contains("linux");
    }

    /**
     * @description: 获取图片路径
     * @param: [fileName]
     * @return: java.lang.String
     * @auther: wangbingan[www.wangbingan.com]
     * @date: 2020/11/17 11:25 上午
     **/
    public static String getImageUrl(String fileName) {
        if (isLinux()) {
            return System.getProperty("user.dir") + "/images/" + fileName;
        }
        return System.getProperty("user.dir") + "/src/main/resources/static/images/article/" + fileName;
    }
}
