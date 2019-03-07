package com.vip.darker.base.dpattern.cor.server;

import com.vip.darker.base.dpattern.cor.handler.PriceHandler;

/**
 * @description: 销售人员, 打折范围0.1
 * @auther: WBA
 * @date: 2019/3/7 10:25
 */
public class Sales extends PriceHandler {
    @Override
    public void discount(float discount) {
        if (0.1 >= discount) {
            System.out.format(this.getClass().getSimpleName() + "接受价格:%.2f%n", discount);
        } else {
            // 拒绝价格,向下传递请求
            successor.discount(discount);
        }
    }
}