package com.vip.darker.base.dpattern.proxy.dynamic;

/**
 * @description: 猪
 * @auther: WBA
 * @date: 2019/3/8 10:58
 */
public class JDKPig implements JDKAnimal {
    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + ":run");
    }
}