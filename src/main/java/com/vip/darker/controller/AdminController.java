package com.vip.darker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    private static final String ADMIN = "admin";

    @RequestMapping(value = ADMIN, method = RequestMethod.GET)
    public String admin() {
        return ADMIN + "/admin";
    }
}
