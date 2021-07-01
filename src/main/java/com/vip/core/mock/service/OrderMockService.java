package com.vip.core.mock.service;

public interface OrderMockService {

    /**
     * 创建订单
     *
     * @param productName 产品
     * @param orderNum    订单数
     * @param userId      用户
     * @return
     * @throws Exception
     */
    Long createOrder(String productName, Integer orderNum, int userId) throws Exception;
}
