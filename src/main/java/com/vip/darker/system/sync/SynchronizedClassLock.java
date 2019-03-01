package com.vip.darker.system.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Darker
 * @Date: 2019/02/27
 * @Description: 同步类锁
 */
public class SynchronizedClassLock implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedClassLock.class);

    private static int num = 0;

    private static int count = 10000;

    private static SynchronizedClassLock o = new SynchronizedClassLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(o);
        Thread t2 = new Thread(o);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info(num + "");
    }

    @Override
    public void run() {
        lockclass();
    }

    /**
     * @description: 类锁
     * @auther: WBA
     * @date: 2019/2/27 16:13
     * @param: []
     * @return: void
     */
    private void lockclass() {
        synchronized (SynchronizedClassLock.class) {
            logger.info(Thread.currentThread().getName() + ":starting");
            for (int i = 0; i < count; i++) {
                num++;
            }
            logger.info(Thread.currentThread().getName() + ":ending");
        }
    }

    /**
     * @description: 静态方法锁
     * @auther: WBA
     * @date: 2019/2/27 16:13
     * @param: []
     * @return: void
     */
    private static synchronized void lockstaticmethod() {
        logger.info(Thread.currentThread().getName() + ":starting");
        for (int i = 0; i < count; i++) {
            num++;
        }
        logger.info(Thread.currentThread().getName() + ":ending");
    }
}