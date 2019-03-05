package com.vip.darker.base.dpattern.singleton;

/**
 * @description: 单例模式测试用例
 * @auther: WBA
 * @date: 2019/3/5 9:54
 * @定义: 操作同一个对象实例
 * @应用场景: 1.静态对象(类对象) 2.数据库 3.配置文件等
 * @饿汉模式与懒汉模式的区别 1.饿汉模式编译期运行慢, 调用期运行快;懒汉模式编译期运行快, 调用期运行慢
 */
public class SingletonTest {

    public static void main(String[] args) {
        HSingleton instance1 = HSingleton.getInstance();
        HSingleton instance2 = HSingleton.getInstance();
        System.out.println(instance1 == instance2);

        LSingleton instance3 = LSingleton.getInstance();
        LSingleton instance4 = LSingleton.getInstance();
        System.out.println(instance3 == instance4);
    }
}