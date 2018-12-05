package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.ConvertAttribute;
import com.vip.darker.util.WebSiteUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 15:05
 * @DateUpdate: 2018/8/2
 * @Description: 内容管理控制器
 */
@RestController
@RequestMapping(value = "content")
public class ContentController {

    //****************************************文章模块****************************************//

    /**
     * 功能描述: 文章新增
     *
     * @param: [articleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:22
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public Map<String, Object> addArticle(ArticleModel articleModel) {
        // 重新设置summary,防止出现空简介
        if ("<p></p>".equals(WebSiteUtil.replaceBlank(articleModel.getSummary()))) {
            articleModel.setSummary("");
        }
        boolean flag = SpringBootService.getArticleService().insert(articleModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

        return map;
    }

    /**
     * 功能描述:文章更新
     *
     * @param: [articleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:28
     */
    @RequestMapping(value = "/updateArticle", method = RequestMethod.PUT)
    public Map<String, Object> updateArticle(ArticleModel articleModel) {

        boolean flag = SpringBootService.getArticleService().updateById(articleModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * 功能描述: 文章删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:35
     */
    @RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteArticle(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getArticleService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 文章列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/articleMaxPage", method = RequestMethod.GET)
    public Map<String, Object> countArticleMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getArticleService().selectCount(new EntityWrapper<>());

        map.put("articleMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * 功能描述: 文章对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ArticleModel
     * @auther: darker
     * @date: 2018/8/1 16:49
     */
    @RequestMapping(value = "/allArticle/{id}", method = RequestMethod.GET)
    public ArticleModel findArticleById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getArticleService().selectById(id);
    }

    /**
     * 功能描述: 文章列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ArticleModel>
     * @auther: darker
     * @date: 2018/7/20 15:49
     */
    @RequestMapping(value = "/allArticle", method = RequestMethod.GET)
    public List<ArticleModel> findListArticle(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        List<ArticleModel> list = SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();

        list.forEach(opt -> {
            opt.setClassifyName(ConvertAttribute.getClassifyMap().get(opt.getClassifyId()));
            opt.setColumnName(ConvertAttribute.getColumnMap().get(opt.getColumnId()));
        });

        return list;
    }

    //****************************************留言板模块****************************************//

    /**
     * 功能描述: 留言板新增
     *
     * @param: [messageModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:25
     */
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public Map<String, Object> addMessage(Integer articleId, MessageModel messageModel) {
        // 留言新增
        SpringBootService.getMessageService().insert(messageModel);
        // 留言信息
        List<MessageModel> messageModelList = SpringBootService.getMessageService().selectList(new EntityWrapper<MessageModel>().where("articleId={0}", articleId));

        Map<String, Object> map = new HashMap<>();

        map.put("messageList", messageModelList);

        return map;
    }

    /**
     * 功能描述: 留言板更新
     *
     * @param: [messageModel]
     * @return:
     * @auther: darker
     * @date: 2018/7/20 15:31
     */
    @RequestMapping(value = "/updateMessage", method = RequestMethod.PUT)
    public Map<String, Object> updateMessage(MessageModel messageModel) {

        boolean flag = SpringBootService.getMessageService().updateById(messageModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * 功能描述: 留言板删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:39
     */
    @RequestMapping(value = "/deleteMessage/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteMessage(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getMessageService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 留言列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/2 22:56
     */
    @RequestMapping(value = "/messageMaxPage", method = RequestMethod.GET)
    public Map<String, Object> countMessageMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getMessageService().selectCount(new EntityWrapper<>());

        map.put("messageMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * 功能描述: 留言对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.MessageModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/allMessage/{id}", method = RequestMethod.GET)
    public MessageModel findMessageById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getMessageService().selectById(id);
    }

    /**
     * 功能描述: 留言列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MessageModel>
     * @auther: darker
     * @date: 2018/7/20 15:43
     */
    @RequestMapping(value = "/allMessage", method = RequestMethod.GET)
    public List<MessageModel> findListMessage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}