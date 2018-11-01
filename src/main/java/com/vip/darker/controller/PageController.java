package com.vip.darker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Darker
 * @Date: 2018/9/03 10:24
 * @Description: 全局异常跳转页面控制器
 */
@Controller
@RequestMapping(value = PageController.BEAN_NAME)
public class PageController {

    public static final String BEAN_NAME = "error";

    @RequestMapping("/404")
    public String error404() {
        return BEAN_NAME + "/404";
    }

    @RequestMapping("/500")
    public String error500() {
        return BEAN_NAME + "/500";
    }
}