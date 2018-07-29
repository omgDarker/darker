package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: Darker
 * @description ：内容管理页面CONTROLLER
 * @date : 2018/7/17 23:08
 */
@RestController
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

        ModelAndView modelAndView = new ModelAndView( "admin/home" );

        int count = SystemServiceLocator.getResourceService().selectCount( new EntityWrapper<>() );

        modelAndView.addObject( "maxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return modelAndView;
    }
}
