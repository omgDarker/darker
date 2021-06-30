package com.vip.core.mock;

import org.mockito.ArgumentMatcher;

import java.util.HashSet;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/6/30 5:46 下午
 * @version: v1.0.0
 */
public class IsValid extends ArgumentMatcher<HashSet> {

    /**
     * 需要注意的是如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
     *
     * @param o
     * @return
     */
    @Override
    public boolean matches(Object o) {
        return (int) o == 1 || (int) o == 2;
    }
}
