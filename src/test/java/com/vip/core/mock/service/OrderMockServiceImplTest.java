package com.vip.core.mock.service;

import com.vip.core.mock.service.impl.OrderMockServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: mock测试用例
 * @date: 2021/7/1 2:48 下午
 * @version: v1.0.0
 */
@Slf4j
public class OrderMockServiceImplTest {

    /**
     * mock初始化（@RunWith(MockitoJUnitRunner.class)也可以）
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 真正要测试的类
     */
    @InjectMocks
    private OrderMockServiceImpl orderMockService;

    /**
     * 测试类依赖的其他服务,并不会真正执行内部的代码
     */
    @Mock
    private UserMockService userMockService;

    /**
     * createOrder成功时的用例
     */
    @Test
    public void junitCreateOrderSuccess() throws Exception {
        BigDecimal balance = BigDecimal.TEN;
        // 使用mock对象,当调用mock接口的时候,返回值是balance
        when(userMockService.queryBalance(88)).thenReturn(balance);
        // 调用真正测试的接口
        long orderId = orderMockService.createOrder("测试产品", 100, 88);
        // 验证结果
        Assert.assertEquals(orderId, 1);
    }

    /**
     * createOrder失败时的用例（校验参数）
     */
    @Test
    public void junitCreateOrderFailure() {
        try {
            orderMockService.createOrder(null, 10, 80);
        } catch (Exception e) {
//            log.error("异常捕获", e);
            assertTrue(true);
        }

        try {
            orderMockService.createOrder("book", null, 70);
        } catch (Exception e) {
            assertTrue(true);
        }

        try {
            orderMockService.createOrder("book", 0, 60);
        } catch (Exception e) {
            assertTrue(true);
        }

        try {
            orderMockService.createOrder("book", 50, 50);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
