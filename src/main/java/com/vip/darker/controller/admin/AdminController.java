package com.vip.darker.controller.admin;

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
public class AdminController {

    private static final String ADMIN = "admin";

    /**
     * @description:登录页跳转
     * @auther: WBA
     * @date: 2018/12/11 14:33
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(ADMIN + "/login");
    }

    /**
     * @description:用户注册
     * @auther: WBA
     * @date: 2018/12/11 14:53
     * @param: [userModel]
     * @return: Map
     */
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public Map<String, Object> register(UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        // 判断是否存在此用户
        Optional<Object> opt = Optional.ofNullable(
                SpringBootService.getUserService().selectObj(
                        new EntityWrapper<UserModel>()
                                .where("name={0}", userModel.getName())
                                .and("password={0}", userModel.getPassword())));
        if (opt.isPresent()) {
            map.put(Constant.MSG, "已存在!");
        } else {
            map.put(Constant.MSG, SpringBootService.getUserService().insert(userModel) ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);
        }
        return map;
    }

    /**
     * @description:博客后台首页
     * @auther: WBA
     * @date: 2018/12/11 14:56
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {

        ModelAndView modelAndView = new ModelAndView(ADMIN + "/home");

        int count = SpringBootService.getResourceService().selectCount(new EntityWrapper<>());

        modelAndView.addObject("maxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return modelAndView;
    }
}