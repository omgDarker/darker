package com.vip.darker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : P2M.WBA
 * @description ：首页访问CONTROLLER
 * @date : 2018/7/17 11:05
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {

    private static final String INDEX = "index";

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
        return INDEX + "/home";
    }

    /**
     * 简介
     *
     * @return
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return INDEX + "/about";
    }

    /**
     * 相册
     *
     * @return
     */
    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public String photo() {
        return INDEX + "/photo";
    }

    /**
     * 日记
     *
     * @return
     */
    @RequestMapping(value = "/diary", method = RequestMethod.GET)
    public String diary() {
        return INDEX + "/diary";
    }

    /**
     * 笔记
     *
     * @return
     */
    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public String note() {
        return INDEX + "/note";
    }

    /**
     * 技术文章
     *
     * @param classify 分类
     * @return
     */
    @RequestMapping(value = "/article/{classify}", method = RequestMethod.GET)
    public String article(@PathVariable(value = "classify") String classify) {
        return INDEX + "/article";
    }

    /**
     * 留言板
     *
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message() {
        return INDEX + "/message";
    }
}
