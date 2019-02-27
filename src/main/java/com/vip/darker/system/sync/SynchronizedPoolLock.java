package com.vip.darker.system.sync;

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

    private static int num = 0;

    private static int count = 10000;

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 60L;
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new SynchronousQueue(), (ThreadFactory) Thread::new);
        // 创建线程方法
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + ":starting");
            synchronized (SynchronizedPoolLock.class) {
                for (int i = 0; i < count; i++) {
                    num++;
                }
                System.out.println(num);
            }
            System.out.println(Thread.currentThread().getName() + ":ending");
        };
        // 启动线程池中的线程
        int poolSize = 2;
        for (int i = 0; i < poolSize; i++) {
            executor.submit(r);
        }
        executor.shutdown();
    }
}