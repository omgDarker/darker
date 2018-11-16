package com.vip.darker.controller.home;

import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 网站首页入口controller
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * 功能描述: 博客首页
     *
     * @param: [request, response]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/", "/index", "/home"})
    public String home(HttpServletRequest request, HttpServletResponse response) {
        // 重置在线人数
        SessionUtil.resetOnlineList(request, response);
        return "index/welcome";
    }
}