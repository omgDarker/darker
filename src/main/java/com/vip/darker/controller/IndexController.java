package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        // 文章
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage(new Page<>(1, 5)).getRecords();
        // 处理日记长度
        for (ArticleModel model : list) {
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
        // 文章信息
        ArticleModel articleModel = SystemServiceLocator.getArticleService().selectById(id);
        // 留言信息
        List<MessageModel> messageModelList = SystemServiceLocator.getMessageService().selectList(new EntityWrapper<MessageModel>().where("articleId={0}", id));

        modelAndView.addObject("article", articleModel);
        modelAndView.addObject("messageList", messageModelList);

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
    public ModelAndView photo(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/photo");
        // 获取所有图片名称
        List<PhotoModel> photoModelList = SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize)).getRecords();

        modelAndView.addObject("photoList",photoModelList);
        modelAndView.addObject("pageNum",pageNum);

        return modelAndView;
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
     * 功能描述: 文章
     *
     * @param: [classify<大类></>, column<下拉框></>]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView article(
            @PathVariable(value = "classifyId") String classifyId,
            @PathVariable(value = "columnId") String columnId,
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/article");
        // 根据条件查询文章
        List<ArticleModel> articleModelList = SystemServiceLocator.getArticleService()
                .selectPage(new Page<>(pageNum,pageSize),
                        new EntityWrapper<ArticleModel>()
                                .where("classifyId={0} ",classifyId)
                                .and("columnId={0}",columnId)).getRecords();

        modelAndView.addObject("articleList",articleModelList);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("classifyId",classifyId);
        modelAndView.addObject("columnId",columnId);

        return modelAndView;
    }

    /**
     * 留言板
     *
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView message(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 返回页面
        ModelAndView modelAndView = new ModelAndView(INDEX + "/message");
        // 查询所有留言信息
        List<MessageModel> messageModelList = SystemServiceLocator.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();

        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("messageList", messageModelList);

        return modelAndView;
    }
}
