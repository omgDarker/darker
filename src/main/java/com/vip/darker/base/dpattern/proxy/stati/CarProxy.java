package com.vip.darker.base.dpattern.proxy.stati;

/**
 * @description: 代理对象
 * @auther: WBA
 * @date: 2019/3/8 10:41
 * @优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
 * @缺点：因为代理对象，需要实现与目标对象一样的接口，会导致代理类十分繁多，不易维护，同时一旦接口增加方法，则目标对象和代理类都需要维护。
 */
public class CarProxy implements Car {

    private Car car;

    /**
     * @description: 通过构造方法, 获取代理对象
     * @auther: WBA
     * @date: 2019/3/8 10:43
     * @param: [car]
     * @return:
     */
    public CarProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        // 代理的额外业务
        System.out.println("carProxy starting!");
        car.move();
        // 代理的额外业务
        System.out.println("carProxy stoping!");
    }
}