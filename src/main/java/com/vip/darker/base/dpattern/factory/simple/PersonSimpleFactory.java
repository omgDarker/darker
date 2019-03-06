package com.vip.darker.base.dpattern.factory.simple;


import com.vip.darker.base.dpattern.factory.simple.service.Behavior;
import com.vip.darker.base.dpattern.factory.simple.service.impl.Chef;
import com.vip.darker.base.dpattern.factory.simple.service.impl.Cook;

/**
 * @description:简单工厂模式(不符合"开放-封闭"原则)
 * @auther: WBA
 * @date: 2019/3/6 9:33
 */
public class PersonSimpleFactory {

    public static Behavior getBehavior(String key) {
        // 增加一种实现类,这里就会增加一种情况
        if ("man".equals(key)) {
            return new Chef();
        } else if ("woman".equals(key)) {
            return new Cook();
        } else {
            return null;
        }
    }
}