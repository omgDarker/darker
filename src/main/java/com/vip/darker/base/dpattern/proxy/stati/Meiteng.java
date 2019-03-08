package com.vip.darker.base.dpattern.proxy.stati;


/**
 * @description: 迈腾汽车
 * @auther: WBA
 * @date: 2019/3/8 10:37
 */
public class Meiteng implements Car {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + ":move");
    }
}