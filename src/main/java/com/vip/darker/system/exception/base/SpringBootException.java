package com.vip.darker.system.exception.base;

import com.vip.darker.system.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auther: Darker
 * @description ：全局异常配置
 * @date : 2018/9/12 16:36
 */
@ControllerAdvice
public class SpringBootException {

    /**
     * @description:登录异常,返回登录页面
     * @auther: WBA
     * @date: 2018/12/11 17:04
     * @param: [e]
     * @return: java.lang.String
     */
    @ExceptionHandler(value = LoginException.class)
    public String errorLogin(Exception e) {
        return "/admin/login";
    }
}