package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: Darker
 * @description ：内容管理页面CONTROLLER
 * @date : 2018/7/17 23:08
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    private static final String ADMIN = "admin";

    private final ResourceService resourceService;

    @Autowired
    public AdminController(@Qualifier(value = "resourceService") ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * 功能描述: 内容管理首页
     *
     * @param: [model]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/7/24 23:08
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String admin(Model model) {
        List<ResourceModel> list = resourceService.selectPage( new Page<>( 1, 10 ) ).getRecords();
        model.addAttribute( "resourceList", list );
        return ADMIN + "/home";
    }
}
