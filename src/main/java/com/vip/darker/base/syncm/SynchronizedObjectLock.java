package com.vip.darker.base.syncm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Darker
 * @Date: 2019/02/27
 * @Description: 同步对象锁(同一对象才会抢时间片)
 */
public class SynchronizedObjectLock implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedObjectLock.class);

    private static int num = 0;

    private static int count = 10000;

    private static SynchronizedObjectLock o = new SynchronizedObjectLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(o);
        Thread t2 = new Thread(o);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        logger.info(num + "");
    }

    @Override
    public void run() {
        lockmethod();
    }

    /**
     * @description: 代码块锁
     * @auther: WBA
     * @date: 2019/2/27 15:29
     * @param: []
     * @return: void
     */
    private void lockcode() {
        logger.info(Thread.currentThread().getName() + ":starting");
        synchronized (this) {
            for (int i = 0; i < count; i++) {
                num++;
            }
        }
        logger.info(Thread.currentThread().getName() + ":ending");
    }

    /**
     * @description: 普通方法锁
     * @auther: WBA
     * @date: 2019/2/27 15:30
     * @param: []
     * @return: void
     */
    private synchronized void lockmethod() {
        logger.info(Thread.currentThread().getName() + ":starting");
        for (int i = 0; i < count; i++) {
            num++;
        }
        logger.info(Thread.currentThread().getName() + ":ending");
    }
}