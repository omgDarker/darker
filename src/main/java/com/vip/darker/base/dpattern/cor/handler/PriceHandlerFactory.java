package com.vip.darker.base.dpattern.cor.handler;

import com.vip.darker.base.dpattern.cor.server.Boss;
import com.vip.darker.base.dpattern.cor.server.Manager;
import com.vip.darker.base.dpattern.cor.server.Sales;

/**
 * @description: 处理器工厂
 * @auther: WBA
 * @date: 2019/3/7 11:44
 */
public class PriceHandlerFactory {
    /**
     * @description: 设置传递的顺序
     * @auther: WBA
     * @date: 2019/3/7 11:45
     * @param: []
     * @return: com.vip.darker.base.dpattern.cor.handler.PriceHandler
     */
    public static PriceHandler createHandle() {
        PriceHandler boss = new Boss();
        PriceHandler manager = new Manager();
        PriceHandler sales = new Sales();
        sales.setSuccessor(manager);
        manager.setSuccessor(boss);
        return sales;
    }
}