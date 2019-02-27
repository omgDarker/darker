package com.vip.darker.system.sync;

/**
 * @Auther: Darker
 * @Date: 2019/02/27
 * @Description: 同步对象锁(同一对象才会抢时间片)
 */
public class SynchronizedObjectLock implements Runnable {

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
        System.out.println(num);
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
        System.out.println(Thread.currentThread().getName() + ":starting");
        synchronized (this) {
            for (int i = 0; i < count; i++) {
                num++;
            }
        }
        System.out.println(Thread.currentThread().getName() + ":ending");
    }

    /**
     * @description: 普通方法锁
     * @auther: WBA
     * @date: 2019/2/27 15:30
     * @param: []
     * @return: void
     */
    private synchronized void lockmethod() {
        System.out.println(Thread.currentThread().getName() + ":starting");
        for (int i = 0; i < count; i++) {
            num++;
        }
        System.out.println(Thread.currentThread().getName() + ":ending");
    }
}