package com.vip.core.mock;


import org.junit.Test;
import org.mockito.InOrder;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: mock测试
 * @date: 2021/6/30 4:21 下午
 * @version: v1.0.0
 */
@SuppressWarnings("all")
public class Mockito2Test {

    /**
     * 验证模拟对象行为（是否执行过此操作）
     */
    @Test
    public void verify_behaviour() {
        // 模拟mock对象
        List<Integer> mockList = mock(List.class);
        // 使用mock对象
        mockList.add(1);
        mockList.clear();
        mockList.size();
        // 验证行为是否发生
        verify(mockList).add(1);
        verify(mockList).clear();
        verify(mockList).size();
    }

    /**
     * 验证模拟期望结果
     */
    @Test
    public void when_thenReturn() {
        // 模拟mock对象
        Iterator iterator = mock(Iterator.class);
        // 预设当iterator调用next()时第一次返回daxue,第2次都返回YXFW,第N次返回V587
        when(iterator.next()).thenReturn("DAXUE").thenReturn("YXFW").thenReturn("V587");
        // 使用mock对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next() + " " + iterator.next();
        // 验证结果
        assertEquals("DAXUE YXFW V587 V587", result);
    }

    /**
     * 验证模拟期望异常（待定）
     *
     * @throws Throwable
     */
    @Test(expected = Throwable.class)
    public void when_thenThrow() throws Throwable {
        // 模拟mock对象
        Map<Integer, Object> map = mock(Map.class);
        // 预设当流关闭时抛出异常
        doThrow(new Throwable()).when(map).get(1);
        // 使用mock对象
        map.get(1);
    }

    /**
     * 验证模拟参数匹配
     */
    @Test
    public void with_arguments() {
        // 模拟mock对象
        Comparable comparable = mock(Comparable.class);
        // 预设根据不同的参数返回不同的结果
        when(comparable.compareTo("DAXUE")).thenReturn(587);
        when(comparable.compareTo("YXFW")).thenReturn(666);
        assertEquals(587, comparable.compareTo("DAXUE"));
        assertEquals(666, comparable.compareTo("YXFW"));
        // 对于没有预设的情况会返回默认值0
        // Expected :8888
        // Actual   :0
        assertEquals(0, comparable.compareTo("WANGBINGAN"));
    }

    /**
     * 验证模拟匹配任意参数
     */
    @Test
    public void with_unspecified_arguments() {
        // 模拟mock对象
        Set set = mock(HashSet.class);
        // 增加任意数，返回true
        when(set.add(anyInt())).thenReturn(true);
        // 包含任意数，返回true
        // when(set.contains(argThat(new IsValid()))).thenReturn(false);
        when(set.contains(anyInt())).thenReturn(false);
        assertTrue(set.add(1));
        assertFalse(set.contains(1));
        assertFalse(set.remove(1));
    }

    /**
     * 如果第一个参数使用了参数匹配，即用到了org.mockito.Matchers,那么后面的参数也要用这个类中的方法
     */
    @Test
    public void all_arguments_provided_by_matchers() {
        // 模拟mock对象
        Comparator comparator = mock(Comparator.class);
        // 预设根据不同的参数比较不同的结果
        comparator.compare("DAXUE", "YXFW");
        // 验证结果
        verify(comparator).compare("DAXUE", "YXFW");
        verify(comparator).compare(anyString(), anyString());
        verify(comparator).compare(anyString(), eq("YXFW"));
        verify(comparator).compare(eq("DAXUE"), anyString());
    }

    /**
     * 验证确切的调用次数
     */
    @Test
    public void verifying_number_of_invocations() {
        // 模拟mock对象
        List<Integer> mockList = mock(List.class);
        {
            {
                mockList.add(1);
                mockList.add(2);
                mockList.add(2);
                mockList.add(3);
                mockList.add(4);
                mockList.add(5);
                mockList.add(6);
                mockList.add(6);
                mockList.add(6);
            }
        }
        // 验证list.add(1)是否被调用了1次
        verify(mockList, times(1)).add(1);
        // 验证list.add(2)是否被调用了2次
        verify(mockList, times(2)).add(2);
        // 验证list.add(6)至少被调用1次
        verify(mockList, atLeastOnce()).add(6);
        // 验证list.add(6)至少被调用2次
        verify(mockList, atLeast(2)).add(6);
        // 验证list.add(6)至多被调用3次
        verify(mockList, atMost(3)).add(6);
        // 验证list.add(7)从未被调用过
        verify(mockList, never()).add(7);
    }

    /**
     * 验证模拟方法体抛出异常（待定）
     */
    @Test(expected = Throwable.class)
    public void doThrow_when() {
        // 模拟mock对象
        List<Integer> mockList = mock(List.class);
        // 预设结果
        doThrow(new Throwable()).when(mockList).add(1);
        // 使用mock对象
        mockList.add(99999);
    }

    /**
     * 验证执行顺序
     */
    @Test
    public void verification_in_order() {
        // 模拟mock对象1
        List<Integer> mock1List = mock(List.class);
        // 模拟mock对象2
        List<String> mock2List = mock(List.class);
        // 使用mock对象1,2
        mock1List.add(1);
        mock1List.add(2);
        mock2List.add("DAXUE");
        mock1List.add(3);
        mock2List.add("YXFW");
        // 将需要排序的mock对象放入InOrder
        InOrder inOrder = inOrder(mock1List, mock2List);
        // 验证执行顺序
        inOrder.verify(mock1List).add(1);
        inOrder.verify(mock1List).add(2);
        inOrder.verify(mock2List).add("DAXUE");
        inOrder.verify(mock1List).add(3);
        inOrder.verify(mock2List).add("YXFW");
    }

    /**
     * 验证模拟对象上无互动发生
     */
    @Test
    public void verify_interaction() {
        // 模拟mock对象1
        List<Integer> mock1List = mock(List.class);
        // 模拟mock对象2
        List<Integer> mock2List = mock(List.class);
        // 模拟mock对象3
        List<Integer> mock3List = mock(List.class);
        // 使用mock对象1
        mock1List.add(1);
        // 验证mock对象1
        verify(mock1List).add(1);
        // 验证mock对象1从未执行过add(2);
        verify(mock1List, never()).add(2);
        // 验证有互动行为 mock1List.addAll(mock2List);
        verifyNoMoreInteractions(mock2List, mock3List);
        // 验证零互动行为
        verifyZeroInteractions(mock1List, mock2List);
    }

}
