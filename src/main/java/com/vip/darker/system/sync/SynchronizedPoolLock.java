package com.vip.darker.system.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Darker
 * @Date: 2019/02/27
 * @Description: 线程池同步锁
 */
public class SynchronizedPoolLock {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedClassLock.class);

    private static int num = 0;

    private static int count = 10000;

    public static void main(String[] args) {
        // 核心线程池大小
        int corePoolSize = 5;
        // 最大线程池大小
        int maximumPoolSize = 10;
        // 线程池中超过corePoolSize数目的空闲线程最大存活时间;可以allowCoreThreadTimeOut(true)使得核心线程有效时间
        long keepAliveTime = 60L;
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new SynchronousQueue(), (ThreadFactory) Thread::new);
        // 创建线程方法
        Runnable r = () -> {
            logger.info(Thread.currentThread().getName() + ":starting");
            synchronized (SynchronizedPoolLock.class) {
                for (int i = 0; i < count; i++) {
                    num++;
                }
                logger.info(num + "");
            }
            logger.info(Thread.currentThread().getName() + ":ending");
        };
        // 启动线程池中的线程
        int poolSize = 2;
        for (int i = 0; i < poolSize; i++) {
            executor.submit(r);
        }
        executor.shutdown();
    }
}