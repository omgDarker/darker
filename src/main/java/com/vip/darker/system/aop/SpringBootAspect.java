package com.vip.darker.system.aop;

import com.vip.darker.system.locator.SystemServiceLocator;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @description ：所有controller切面调用方法
 * @date : 2018/8/28 11:32
 */
@Aspect // 申明切面
@Component
public class SpringBootAspect {

    private Logger logger = LoggerFactory.getLogger(SpringBootAspect.class);

    // 申明切点,项目下的所有controller
    @Pointcut(value = "execution(public * com.vip.darker.controller.*.*(..))")
    public void controller() {

    }

    // 前置
    @Before("controller()")
    public void doBefore() {
        // 获取执行方法之前网站浏览量值
        logger.info("当前网站浏览量的值:{}", SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV());
        logger.info("当前网站访问量的值:{}", SystemServiceLocator.getSpringBootPropertiesLoad().getCountUV());
        logger.info("当前网站访问人数的值:{}", SystemServiceLocator.getSpringBootPropertiesLoad().getCountVV());
    }

    // 后置
    @After("controller()")
    public void doAfter() {
        // 获取执行方法之后网站浏览量值
        int countPV = SystemServiceLocator.getSpringBootPropertiesLoad().addCountPV();
        int countVV = SystemServiceLocator.getSpringBootPropertiesLoad().addCountVV();
        int countUV = SystemServiceLocator.getSpringBootPropertiesLoad().addCountUV();
        // 将值写入.yml文件
        SystemServiceLocator.getSpringBootPropertiesLoad().setCountPV(countPV);
        SystemServiceLocator.getSpringBootPropertiesLoad().setCountVV(countVV);
        SystemServiceLocator.getSpringBootPropertiesLoad().setCountUV(countUV);
        logger.info("当前网站浏览量的值:{}", countPV);
        logger.info("当前网站访问量的值:{}", countVV);
        logger.info("当前网站访问人数的值:{}", countUV);
    }
}
