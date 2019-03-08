package com.vip.darker.base.dpattern.proxy;

import com.vip.darker.base.dpattern.proxy.dynamic.*;
import com.vip.darker.base.dpattern.proxy.stati.CarProxy;
import com.vip.darker.base.dpattern.proxy.stati.Ford;

/**
 * @description: 代理模式测试用例
 * @auther: WBA
 * @date: 2019/3/8 10:13
 * @定义: 对象之间的访问, 通过代理对象控制, 隔离直接访问
 * @代理模式分类: 动态代理、静态代理
 * @动态代理分类: JDK动态代理、CGLIB动态代理
 * @JDK动态代理: 利用JAVA反射, 装载代理类的方法进行实现, 通过实现接口来达到目的
 * @CGLIB动态代理: 通过继承基类来到达目的, 子类实现代理方式
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 静态代理
        CarProxy carProxy = new CarProxy(new Ford());
        carProxy.move();
        // JDK动态代理(java.lang.reflect)
        JDKAnimal JDKAnimal = new JDKAnimalProxy(new JDKPig()).getProxy();
        JDKAnimal.run();
        // CGLIB动态代理
        CGLIBProxy cglibProxy = new CGLIBProxy();
        CGLIBAnimal cglibAnimal = (CGLIBAnimal) cglibProxy.getObjectProxy(CGLIBAnimal.class);
        cglibAnimal.run();
    }
}