package com.vip.darker.system.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 10:53
 * @Description: 统计网站访问量
 */
public class RunnableThreadWebVV implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(RunnableThreadWebVV.class);
    // 记录网站访问量
    public static Map<String, Integer> map = new HashMap<>();

    @Override
    public void run() {
        logger.info("统计访问量starting......");
    }

    public static void shutDownWeb() {
        logger.info("统计访问量线程ending......");
    }

    public static int addWebVV(int num) {

        if (num == 0) {
            return 0;
        }

        num++;

        map.put("vv", num);

        return num;
    }
}
