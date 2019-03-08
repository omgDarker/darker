package com.vip.darker.base.dpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动物代理类
 * @auther: WBA
 * @date: 2019/3/8 10:58
 * @优点：代理对象无需实现接口，免去了编写很多代理类的烦恼，同时接口增加方法也无需再维护目标对象和代理对象，只需在事件处理器中添加对方法的判断即可。
 * @缺点：代理对象不需要实现接口，但是目标对象一定要实现接口，否则无法使用JDK动态代理。
 */
public class JDKAnimalProxy implements InvocationHandler {

    private Object target;

    public JDKAnimalProxy(Object target) {
        this.target = target;
    }

    /**
     * @description: 获取被代理接口的实例对象
     * @auther: WBA
     * @date: 2019/3/8 11:37
     * @param: []
     * @return: T
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * @description: 目标对象事件处理器, 即对目标对象方法的执行
     * @auther: WBA
     * @date: 2019/3/8 11:46
     * @param: [proxy, method, args]
     * @return: java.lang.Object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("扩展功能开始......");
        // proxy对象替换成目标对象,否则OOM
        Object result = method.invoke(target);
        System.out.println("扩展功能结束......");
        return result;
    }
}