package com.vip.darker.base.dpattern.factory.bstract;


import com.vip.darker.base.dpattern.factory.bstract.service.Character;
import com.vip.darker.base.dpattern.factory.common.service.Profession;

/**
 * @description: 抽象工厂模式(对应多个对象)
 * @auther: WBA
 * @date: 2019/3/6 9:50
 */
public interface PersonAbstractFactory {
    /**
     * 性格
     */
    Character getCharacter();

    /**
     * 职业
     */
    Profession getProfession();
}