package com.vip.core.mock.service;


import java.math.BigDecimal;

public interface UserMockService {

    /**
     * 查询余额
     *
     * @param userId 用户
     * @return
     */
    BigDecimal queryBalance(int userId);
}
