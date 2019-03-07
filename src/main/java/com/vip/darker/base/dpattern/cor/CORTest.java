package com.vip.darker.base.dpattern.cor;

import com.vip.darker.base.dpattern.cor.client.Customer;
import com.vip.darker.base.dpattern.cor.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * @description: 责任链模式
 * @auther: WBA
 * @date: 2019/3/7 10:53
 * @定义: 请求一层层传递, 直到返回结果, 客户端不关心如何传递, 只关心结果
 * @应用场景: 1.Tomcat Filter 2.spring secutiry 3.JS DOM 模型
 * @优势: 客户端与服务端解耦
 * @劣势: 违背"开放-闭合"原则,性能低,类似递归算法
 */
public class CORTest {

    public static void main(String[] args) {
        // 消费者
        Customer customer = new Customer();
        // 内置处理器
        customer.setPriceHandler(PriceHandlerFactory.createHandle());
        // 设置金额
        Random random = new Random();
        // 消费
        for (int i = 1; i <= 10; i++) {
            customer.discountReq(random.nextFloat());
        }
    }
}