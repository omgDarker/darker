package com.vip.darker.base.dpattern.singleton;

/**
 * @description: 懒汉式
 * @auther: WBA
 * @date: 2019/3/5 9:54
 */
public class LSingleton {
    /**
     * 1.创建私有构造方法,防止外部new对象调用
     */
    private LSingleton() {
    }

    /**
     * 2.创建私有对象实例(volatile防止指令重排)
     */
    private static volatile LSingleton instance = null;

    /**
     * 3.封装对象实例
     */
    public static LSingleton getInstance() {
        if (instance == null) {
            synchronized (LSingleton.class) {
                if (instance == null) {
                    instance = new LSingleton();
                }
            }
        }
        return instance;
    }
}