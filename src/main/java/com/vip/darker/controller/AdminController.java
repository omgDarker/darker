package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * 内容管理首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String admin(HttpServletRequest request, HttpServletResponse response) {
        List<ResourceModel> list = resourceService.selectPage(new Page<>(1, 10)).getRecords();
        request.setAttribute("resourceList", list);
        return ADMIN + "/home";
    }
}
