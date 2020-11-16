package com.vip.darker.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Properties;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 工具类
 * @date: 2020/11/16 5:21 下午
 * @version: v1.0.0
 */
@Slf4j
public class CommonUtil {

    public static boolean isLinux() {
        // Mac OS X
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        return os != null && os.toLowerCase().contains("linux");
    }

    public static String getImageUrl(String fileName) {
        if (isLinux()) {
            return System.getProperty("user.dir") + "/target/classes/static/images/article/" + fileName;
        }
        return System.getProperty("user.dir") + "/src/main/resources/static/images/article/" + fileName;
    }
}
