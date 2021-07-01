package com.vip.core.mock.service.impl;

import com.vip.core.mock.service.UserMockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/7/1 2:30 下午
 * @version: v1.0.0
 */
@Slf4j
@Service("userMockService")
public class UserMockServiceImpl implements UserMockService {

    @Override
    public BigDecimal queryBalance(int userId) {
        log.info("queryBalance=>userId:{}", userId);
        //模拟返回100元余额
        return new BigDecimal(100);
    }
}
