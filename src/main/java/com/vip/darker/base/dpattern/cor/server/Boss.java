package com.vip.darker.base.dpattern.cor.server;

import com.vip.darker.base.dpattern.cor.handler.PriceHandler;

/**
 * @description: 老板, 打折范围0.5
 * @auther: WBA
 * @date: 2019/3/7 10:45
 */
public class Boss extends PriceHandler {
    @Override
    public void discount(float discount) {
        if (0.5 >= discount) {
            System.out.format(this.getClass().getSimpleName() + "接受价格:%.2f%n", discount);
        } else {
            System.out.format(this.getClass().getSimpleName() + "拒绝价格:%.2f%n", discount);
        }
    }
}