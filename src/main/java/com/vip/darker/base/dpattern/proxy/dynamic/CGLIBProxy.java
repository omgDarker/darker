package com.vip.darker.base.dpattern.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: CGLIB动态代理
 * @auther: WBA
 * @date: 2019/3/8 16:37
 */
public class CGLIBProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * @description: 创建代理对象
     * @auther: WBA
     * @date: 2019/3/8 16:59
     * @param: [clazz]
     * @return: java.lang.Object
     */
    public Object getObjectProxy(Class clazz) {
        // 设置父类(本身也可以)
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 创建子类,其实是增强类
        return enhancer.create();
    }

    /**
     * @description: 目标对象事件处理器
     * @auther: WBA
     * @date: 2019/3/8 17:00
     * @param: [o, method, objects, methodProxy]
     * @return: java.lang.Object
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("扩展功能开始......");
        // proxy对象替换成目标对象,否则OOM
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("扩展功能结束......");
        return result;
    }
}