package com.vip.darker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: Darker
 * @Date: 2019/01/09 17:24
 * @Description: 注解
 */
//标注在方法和属性上
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
//运行时
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BKDefinition {
    String value() default "";
}