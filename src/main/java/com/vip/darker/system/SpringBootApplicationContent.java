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

    /**
     * @description:设置applicationContext
     * @auther: WBA
     * @date: 2018/12/11 17:34
     * @param: [applicationContext]
     * @return: void
     */
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBootApplicationContent.applicationContext == null) {
            SpringBootApplicationContent.applicationContext = applicationContext;
        }
    }

    /**
     * @description:获取applicationContext
     * @auther: WBA
     * @date: 2018/12/11 17:34
     * @param: []
     * @return: org.springframework.context.ApplicationContext
     */
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @description:通过name获取Bean
     * @auther: WBA
     * @date: 2018/12/11 17:35
     * @param: [name]
     * @return: java.lang.Object
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * @description:通过class获取Bean
     * @auther: WBA
     * @date: 2018/12/11 17:35
     * @param: [clazz]
     * @return: T
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * @description:通过name,以及Clazz返回指定的Bean
     * @auther: WBA
     * @date: 2018/12/11 17:35
     * @param: [name, clazz]
     * @return: T
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * @description:初始化获取所有controller
     * @auther: WBA
     * @date: 2018/12/11 17:35
     * @param: [clazz]
     * @return: java.lang.String[]
     */
    public static String[] controllers(Class<? extends Annotation> clazz) {
        return getApplicationContext().getBeanNamesForAnnotation(clazz);
    }
}