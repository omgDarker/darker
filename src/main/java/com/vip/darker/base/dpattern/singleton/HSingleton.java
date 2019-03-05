package com.vip.darker.base.dpattern.singleton;

/**
 * @description: 饿汉式
 * @auther: WBA
 * @date: 2019/3/5 9:54
 */
public class HSingleton {
    /**
     * 1.构造方法重写,私有化,禁止实例被外部new对象调用
     */
    private HSingleton() {
    }

    /**
     * 2.创建对象实例
     */
    private static volatile HSingleton instance = new HSingleton();

    /**
     * 3.封装对象实例
     */
    public static synchronized HSingleton getInstance() {
        return instance;
    }
}