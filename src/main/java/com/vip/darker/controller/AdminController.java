package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Darker
 * @description ：内容管理页面CONTROLLER
 * @date : 2018/7/17 23:08
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    /**
     * 功能描述: 内容管理首页
     *
     * @param: [model]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/7/24 23:08
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView admin() {
        List<ResourceModel> list = SystemServiceLocator.getResourceService().selectPage(new Page<>(1, 10)).getRecords();
        ModelAndView modelAndView = new ModelAndView("admin/home");
        modelAndView.addObject("resourceList", list);
        return modelAndView;
    }
}
