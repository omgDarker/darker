package com.vip.darker.system.aop.base;

import com.vip.darker.service.base.SpringBootService;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @description ：监控网站总浏览量
 * @date : 2018/8/28 11:32
 */
@Aspect // 申明切面
@Component
public class SpringBootAspect {

    private Logger logger = LoggerFactory.getLogger(SpringBootAspect.class);

    // 申明切点,监控项目下的所有controller
    @Pointcut(value = "execution(public * com.vip.darker.controller.*.*(..))")
    public void controller() {

    }

    /**
     * 功能描述: 前置通知,在方法执行之前执行
     *
     * @param: []
     * @auther: darker
     * @date: 2018/09/03 11:10
     */
    @Before(value = "controller()")
    public void doBefore() {
    }

    /**
     * 功能描述: 后置通知,在方法执行之后执行
     *
     * @param: []
     * @auther: darker
     * @date: 2018/09/03 11:10
     */
    @After(value = "controller()")
    public void doAfter() {
        // 获取执行方法之后网站浏览量值
        int countPV = SpringBootService.getSpringBootPropertiesLoad().addCountPV();
        // 将值写入.yml文件
        SpringBootService.getSpringBootPropertiesLoad().setCountPV(countPV);
        logger.info("[当前网站浏览量的值]:{}", countPV);

    }

    /**
     * 功能描述: 返回通知,在方法返回结果之后执行
     *
     * @param: []
     * @auther: darker
     * @date: 2018/09/03 11:10
     */
    @AfterReturning(value = "controller()")
    public void doAfterRunning() {
    }

    /**
     * 功能描述: 异常通知,在方法抛出异常之后
     *
     * @param: []
     * @auther: darker
     * @date: 2018/09/03 11:10
     */
    @AfterThrowing(value = "controller()")
    public void doAfterThrowing() {

    }

}
