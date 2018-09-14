package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.UserModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.ConstantUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Darker
 * @description ：后台管理页面控制器
 * @date : 2018/7/17 23:08
 */
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    /**
     * 功能描述: 后台管理首页
     *
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/7/24 23:08
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView admin() {

        ModelAndView modelAndView = new ModelAndView("admin/home");

        int count = SystemServiceLocator.getResourceService().selectCount(new EntityWrapper<>());

        modelAndView.addObject("maxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

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
        Object user = SystemServiceLocator.getUserService().selectObj(new EntityWrapper<UserModel>().where("name={0}", userModel.getName()).and("password={0}", userModel.getPassword()));
        if (user != null) {
            map.put(ConstantUtil.MSG, ConstantUtil.EXIST_USER);
        } else {
            map.put(ConstantUtil.MSG, SystemServiceLocator.getUserService().insert(userModel) ? ConstantUtil.SUCCESS_INSERT : ConstantUtil.FAIL_INSERT);
        }
        return map;
    }
}
