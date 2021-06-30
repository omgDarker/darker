package com.vip.core.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;


/**
 * @author : wangbinga
 * @description: mock测试
 * @date: 2021/6/30 11:48 上午
 * @version: v1.0.0
 */
// 带有@Mock注释的成员，并将其初始化以进行模拟
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    // 创建mock对象
    // @Mock注释告诉Mockito模拟mockList将被视为模拟
    @Mock
    private List<String> mockList;

    @Before
    public void setUp() {
        // 定义mock行为
        // 若获取mockList第一个对象,应该返回success
        // 根据特定的参数来返回特定的值.
        Mockito.when(mockList.get(0)).thenReturn("success");
    }

    @Test
    public void junit() {
        // 调用mock对象方法
        String res = mockList.get(0);
        // 比较实际结果与预期
        Assert.assertEquals(res, "success");
    }
}
