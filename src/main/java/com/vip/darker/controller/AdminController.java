package com.vip.darker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description ：内容管理CONTROLLER
 * @date : 2018/7/17 23:08
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    private static final String ADMIN = "admin";

    /**
     * 内容管理首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String admin() {
        return ADMIN + "/home";
    }
}
