package com.vip.darker.base.dpattern.factory;

import com.vip.darker.base.dpattern.factory.bstract.PersonAbstractFactory;
import com.vip.darker.base.dpattern.factory.bstract.service.impl.EngineerFactory;
import com.vip.darker.base.dpattern.factory.common.PersonFactory;
import com.vip.darker.base.dpattern.factory.common.service.impl.StudentFactory;
import com.vip.darker.base.dpattern.factory.simple.PersonSimpleFactory;
import com.vip.darker.base.dpattern.factory.simple.service.Behavior;
import com.vip.darker.base.dpattern.factory.simple.service.impl.Chef;
import com.vip.darker.base.dpattern.factory.simple.service.impl.Cook;

/**
 * @description: 工厂模式测试用例
 * @auther: WBA
 * @date: 2019/3/6 9:17
 * @定义: 将具体对象抽取出公共部分, 封装起来
 * @应用场景: 1.JDBC(根据数据库不同驱动获取相应的链接) 2.BeanFactory
 * @工厂模式与抽象工厂模式的区别: 1.工厂模式面对一个抽象对象 2.抽象工厂模式面对多个抽象对象
 * @优势: 接口不变, 增加一组实现类即可
 */
public class FactoryTest {

    public static void main(String[] args) {
        //************************************简单工厂模式************************************//
        // 1.通过new获取不同的实例对象
        Behavior chef = new Chef();
        Behavior cook = new Cook();
        chef.eat();
        cook.eat();
        // 2.根据工厂,通过传参获取不同的实例对象
        Behavior behavior = PersonSimpleFactory.getBehavior("cook");
        if (behavior != null) {
            behavior.eat();
        }
        // 3.通过反射获取不同的实例对象
        try {
            Chef classChef = (Chef) Class.forName("com.vip.darker.base.dpattern.factory.simple.service.impl.Chef").newInstance();
            if (classChef != null) {
                classChef.eat();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //************************************工厂模式************************************//
        PersonFactory studentFactory = new StudentFactory();
        studentFactory.getProfession().teach();
        //************************************抽象工厂模式************************************//
        PersonAbstractFactory engineerFactory = new EngineerFactory();
        engineerFactory.getCharacter().blandness();
        engineerFactory.getProfession().design();
    }
}