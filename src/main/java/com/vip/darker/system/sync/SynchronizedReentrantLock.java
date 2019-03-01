package com.vip.darker.system.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Darker
 * @Date: 2019/03/01
 * @Description: Lock演示
 */
public class SynchronizedReentrantLock {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedReentrantLock.class);

    private static Lock lock = new ReentrantLock();

    private static int num = 0;

    private static int count_run = 100000000;

    public static void main(String[] args) {
        SynchronizedReentrantLock.start();
    }

    public static void start() {
        // 核心线程池大小
        int corePoolSize = 5;
        // 最大线程池大小
        int maximumPoolSize = 10;
        // 线程池中超过corePoolSize数目的空闲线程最大存活时间;可以allowCoreThreadTimeOut(true)使得核心线程有效时间
        long keepAliveTime = 60L;
        // 2.线程创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                // 线程工厂
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        logger.info("create thread:" + r);
                        return t;
                    }
                },
                // 策略拒绝处理器
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        logger.error(r.toString(), e);
                    }
                });
        // 3.线程运行
        Runnable r = new Runnable() {
            @Override
            public void run() {
                logger.info(Thread.currentThread().getName() + ":starting");
                lock.lock();
                for (int i = 0; i < count_run; i++) {
                    num++;
                }
                logger.info(num + "");
                lock.unlock();
                logger.info(Thread.currentThread().getName() + ":ending");
            }
        };
        // 1.线程启动
        int count_start = 2;
        for (int j = 0; j < count_start; j++) {
            executor.submit(r);
        }
        executor.shutdown();
    }
}