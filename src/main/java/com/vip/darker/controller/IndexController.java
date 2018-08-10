package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.DiaryModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Darker
 * @description ：博客页面CONTROLLER
 * @date : 2018/7/17 11:05
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {

    private static final String INDEX = "index";

    /**
     * 博客首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        // 返回页面
        ModelAndView modelAndView = new ModelAndView(INDEX + "/home");
        // 日记
        List<DiaryModel> list = SystemServiceLocator.getDiaryService().selectPage(new Page<>(1, 5)).getRecords();
        // 处理日记长度
        for (DiaryModel model : list) {
            model.setContent(model.getContent().substring(0, model.getContent().length() > 100 ? 100 : model.getContent().length()));
        }

        modelAndView.addObject("list", list);

        return modelAndView;
    }

    /**
     * 功能描述: 文章详情页<阅读原文>
     *
     * @param: [id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/10 16:49
     */
    @RequestMapping(value = "/detail/article/{id}", method = RequestMethod.GET)
    public ModelAndView detailArticle(@PathVariable(value = "id") Integer id) {
        // 返回页面
        ModelAndView modelAndView = new ModelAndView(INDEX + "/detail_article");
        // 返回数据
        DiaryModel diaryModel = SystemServiceLocator.getDiaryService().selectById(id);

        modelAndView.addObject("object", diaryModel);

        return modelAndView;
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
     * 慢生活
     *
     * @param classify 日记分类{1.每周一记 2.随笔记录}
     * @return
     */
    @RequestMapping(value = "/diary/{classify}", method = RequestMethod.GET)
    public String diary(@PathVariable(value = "classify") String classify) {
        return INDEX + "/diary";
    }

    /**
     * 学无止境
     *
     * @param classify 文章分类
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
