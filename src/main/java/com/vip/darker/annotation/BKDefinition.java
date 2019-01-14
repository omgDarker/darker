package com.vip.darker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: Darker
 * @Date: 2019/01/09 17:24
 * @Description: DO注解
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) //标注在方法和属性上
@Retention(value = RetentionPolicy.RUNTIME) //运行时
public @interface BKDefinition {
    String value() default "";
}