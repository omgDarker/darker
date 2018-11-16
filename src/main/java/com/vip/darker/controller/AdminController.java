package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: Darker
 * @description ：博客后台控制器
 * @date : 2018/7/17 23:08
 */
@RestController
@RequestMapping(value = AdminController.ADMIN)
public class AdminController {

    static final String ADMIN = "admin";

    /**
     * 功能描述: 后台登录跳转
     *
     * @return: modelAndView
     * @auther: darker
     * @date: 2018/9/14 18:31
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(ADMIN + "/login");
    }

    /**
     * 功能描述: 后台管理首页
     *
     * @return: modelAndView
     * @auther: darker
     * @date: 2018/7/24 23:08
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView admin() {

        ModelAndView modelAndView = new ModelAndView(ADMIN + "/home");

        int count = SpringBootService.getResourceService().selectCount(new EntityWrapper<>());

        modelAndView.addObject("maxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return modelAndView;
    }

    /**
     * 功能描述: 用户注册
     *
     * @param: [userModel]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/9/12 18:11
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        // 判断是否存在此用户
        Optional.ofNullable(SpringBootService.getUserService().selectObj(new EntityWrapper<UserModel>().where("name={0}", userModel.getName()).and("password={0}", userModel.getPassword())))
                .map(opt -> map.put(Constant.MSG, "用户已存在!"))
                .orElse(map.put(Constant.MSG, SpringBootService.getUserService().insert(userModel) ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT));
        return map;
    }
}