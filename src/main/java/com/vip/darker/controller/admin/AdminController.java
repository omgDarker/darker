package com.vip.darker.controller.admin;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.entity.UserDO;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.utils.ConstantUtil;
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
    public Map<String, Object> register(UserDO userDO) {
        Map<String, Object> map = new HashMap<>();
        // 判断是否存在此用户
        Optional<Object> opt = Optional.ofNullable(
                SpringBootService.getUserService().selectObj(
                        new EntityWrapper<UserDO>()
                                .where("name={0}", userDO.getName())
                                .and("password={0}", userDO.getPassword())));
        if (opt.isPresent()) {
            map.put(ConstantUtil.MSG, "已存在!");
        } else {
            map.put(ConstantUtil.MSG, SpringBootService.getUserService().insert(userDO) ? OperationStatusEnum.SUCCESS_INSERT.getName() : OperationStatusEnum.FAIL_INSERT.getName());
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

        modelAndView.addObject("maxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

        return modelAndView;
    }
}