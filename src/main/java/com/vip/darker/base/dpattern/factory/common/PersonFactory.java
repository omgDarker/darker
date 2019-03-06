package com.vip.darker.base.dpattern.factory.common;

import com.vip.darker.base.dpattern.factory.common.service.Profession;

/**
 * @description:工厂模式(符合"开放-封闭"原则)
 * @auther: WBA
 * @date: 2019/3/6 9:33
 */
public interface PersonFactory {
    /**
     * 创建职业
     */
    Profession getProfession();
}