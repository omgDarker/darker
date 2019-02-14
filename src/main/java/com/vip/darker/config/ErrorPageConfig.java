package com.vip.darker.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Author: Darker
 * @Date: 2018/9/03 10:24
 * @Description: 全局异常跳转页面配置
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {

        ErrorPage[] errorPageArray = new ErrorPage[2];

        errorPageArray[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        errorPageArray[1] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");

        registry.addErrorPages(errorPageArray);
    }
}