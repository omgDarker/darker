package com.vip.darker.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.lang.annotation.Annotation;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 17:13
 * @Description: spring容器上下文, 用于初始化获取bean
 */
public class SpringBootApplicationContent {

    private static ApplicationContext applicationContext = null;

    // 设置applicationContext
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBootApplicationContent.applicationContext == null) {
            SpringBootApplicationContent.applicationContext = applicationContext;
        }
    }

    // 获取applicationContext
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取Bean
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    // 通过class获取Bean
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    // 初始化获取所有controller
    public static String[] controllers(Class<? extends Annotation> clazz) {
        return getApplicationContext().getBeanNamesForAnnotation(clazz);
    }
}
