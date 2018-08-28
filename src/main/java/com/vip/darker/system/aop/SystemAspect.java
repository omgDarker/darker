package com.vip.darker.system.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Darker
 * @description ：浏览量统计
 * @date : 2018/8/28 11:32
 */
@Order(1)
@Aspect // 申明切面
@Component
public class VisitViewAspect {
    // 申明切点
    @Pointcut(value = "execution(public * com.vip.darker.controller.*.*(..))")
    public void log() {

    }

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(VisitViewAspect.class);
    // 统计请求处理时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("log()")
    public void doBefore() {
        // 设置当前时间
        startTime.set(System.currentTimeMillis());
        // 接收请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容
        System.out.println("Aspect_URL:" + request.getRequestURL().toString());
        System.out.println("Aspect_Method:" + request.getMethod());
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) {
        //处理完请求后，返回内容
        System.out.println("方法返回值:" + JSON.toJSONString(ret) + ",方法执行时间:" + (System.currentTimeMillis() - startTime.get()));
    }
}
