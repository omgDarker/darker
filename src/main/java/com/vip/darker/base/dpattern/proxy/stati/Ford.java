package com.vip.darker.base.dpattern.proxy.stati;


/**
 * @description: 福特汽车
 * @auther: WBA
 * @date: 2019/3/8 10:37
 */
public class Ford implements Car {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + ":move");
    }
}