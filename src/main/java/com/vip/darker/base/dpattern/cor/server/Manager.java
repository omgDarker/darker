package com.vip.darker.base.dpattern.cor.server;

import com.vip.darker.base.dpattern.cor.handler.PriceHandler;

/**
 * @description: 经理, 打折范围0.2
 * @auther: WBA
 * @date: 2019/3/7 10:42
 */
public class Manager extends PriceHandler {
    @Override
    public void discount(float discount) {
        if (0.2 >= discount) {
            System.out.format(this.getClass().getSimpleName() + "接受价格:%.2f%n", discount);
        } else {
            successor.discount(discount);
        }
    }
}