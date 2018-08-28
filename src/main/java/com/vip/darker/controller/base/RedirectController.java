package com.vip.darker.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 重置项controller
 */
@Controller
public class RedirectController {

    /**
     * 功能描述: 博客首页
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/", "/index", "/index/","/index/home"})
    public String defaultIndex() {

        return "redirect:index/home";
    }

    /**
     * 功能描述: 关于我
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/about", "/about/"})
    public String defaultAbout() {
        return "redirect:index/about";
    }

    /**
     * 功能描述: 相册
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/photo", "/photo/"})
    public String defaultPhoto() {
        return "redirect:index/photo";
    }

    /**
     * 功能描述: 留言板
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/message", "/message/"})
    public String defaultMessage() {
        return "redirect:index/message";
    }

}
