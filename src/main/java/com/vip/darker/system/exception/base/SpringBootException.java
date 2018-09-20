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
     * 功能描述: 登录异常,返回登录页面
     *
     * @return: [String]
     * @auther: darker
     * @date: 2018/9/12 16:47
     */
    @ExceptionHandler(value = LoginException.class)
    public String errorLogin(Exception e) {
        return "/admin/login";
    }
}
