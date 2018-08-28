package com.vip.darker.system.aop;

import com.vip.darker.system.locator.SystemServiceLocator;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @description ：所有controller切面调用方法
 * @date : 2018/8/28 11:32
 */
@Aspect // 申明切面
@Component
public class SpringBootAspect {

    // 申明切点
    @Pointcut(value = "execution(public * com.vip.darker.controller.*.*(..))")
    public void statistics() {

    }

    @Before("statistics()")
    public void doBefore() {
        // 初始化获取浏览量信息
        System.out.println("当前访问量的值:" + SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV());
    }

    @After("statistics()")
    public void doAfter() {
        // 获取当前浏览量的值
        int countPV = SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV();
        // 一次请求值+1
        countPV += 1;
        // 将值写入.yml文件
        SystemServiceLocator.getSpringBootPropertiesLoad().setCountPV(countPV);
        System.out.println("现访问量的值:" + countPV);
    }
}
