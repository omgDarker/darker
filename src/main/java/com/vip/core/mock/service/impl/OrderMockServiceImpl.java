package com.vip.core.mock.service.impl;

import com.vip.core.mock.service.OrderMockService;
import com.vip.core.mock.service.UserMockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/7/1 2:27 下午
 * @version: v1.0.0
 */
@Slf4j
@Service("orderMockService")
public class OrderMockServiceImpl implements OrderMockService {

    @Autowired
    private UserMockService userMockService;

    @Override
    public Long createOrder(String productName, Integer orderNum, int userId) throws Exception {
        log.info("createOrder=>userId:{}", userId);
        if (StringUtils.isEmpty(productName)) {
            throw new Exception("productName is empty");
        }

        if (orderNum == null) {
            throw new Exception("orderNum is null!");
        }

        if (orderNum <= 0) {
            throw new Exception("orderNum must bigger than 0");
        }
        // 下订单过程略，返回1L做为订单号
        Long orderId = 1L;

        // 模拟检测余额
        BigDecimal balance = userMockService.queryBalance(userId);
        if (balance.compareTo(BigDecimal.TEN) <= 0) {
            log.warn("余额不足10元，请及时充值!");
        }
        return orderId;
    }
}
