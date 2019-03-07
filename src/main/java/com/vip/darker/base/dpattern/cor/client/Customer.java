package com.vip.darker.base.dpattern.cor.client;

import com.vip.darker.base.dpattern.cor.handler.PriceHandler;

/**
 * @description: 消费者
 * @auther: WBA
 * @date: 2019/3/7 10:07
 */
public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void discountReq(float discount){
        priceHandler.discount(discount);
    }
}