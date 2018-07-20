package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.DiaryModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.service.ArticleService;
import com.vip.darker.service.DiaryService;
import com.vip.darker.service.MessageService;
import com.vip.darker.service.PhotoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 15:05
 * @Description: 内容管理Controller
 */
@RestController
@RequestMapping(value = "content")
public class ContentController {

    private DiaryService diaryService;
    private ArticleService articleService;
    private PhotoService photoService;
    private MessageService messageService;

    public ContentController(
            @Qualifier(value = "diaryService") DiaryService diaryService,
            @Qualifier(value = "articleService") ArticleService articleService,
            @Qualifier(value = "photoService") PhotoService photoService,
            @Qualifier(value = "messageService") MessageService messageService) {
        this.diaryService = diaryService;
        this.articleService = articleService;
        this.photoService = photoService;
        this.messageService = messageService;
    }

    /**
     * 功能描述:日志新增
     *
     * @param: [diaryModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:20
     */
    @RequestMapping(value = "/addDiary", method = RequestMethod.POST)
    public boolean addDiary(DiaryModel diaryModel) {
        return diaryService.insert(diaryModel);
    }

    /**
     * 功能描述: 日志更新
     *
     * @param: [diaryModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:26
     */
    @RequestMapping(value = "/updateDiary", method = RequestMethod.PUT)
    public boolean updateDiary(@RequestBody DiaryModel diaryModel) {
        return diaryService.updateById(diaryModel);
    }

    /**
     * 功能描述: 日志删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:33
     */
    @RequestMapping(value = "/deleteDiary/{id}", method = RequestMethod.DELETE)
    public boolean deleteDiary(@PathVariable(value = "id") Integer id) {
        return diaryService.deleteById(id);
    }

    /**
     * 功能描述: 日志分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.DiaryModel>
     * @auther: darker
     * @date: 2018/7/20 15:52
     */
    @RequestMapping(value = "/allDiary", method = RequestMethod.GET)
    public List<DiaryModel> queryAllDiary(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return diaryService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 文章新增
     *
     * @param: [articleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:22
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public boolean addArticle(ArticleModel articleModel) {
        return articleService.insert(articleModel);
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
    public boolean updateArticle(@RequestBody ArticleModel articleModel) {
        return articleService.updateById(articleModel);
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
    public boolean deleteArticle(@PathVariable(value = "id") Integer id) {
        return articleService.deleteById(id);
    }

    /**
     * 功能描述: 文章分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ArticleModel>
     * @auther: darker
     * @date: 2018/7/20 15:49
     */
    @RequestMapping(value = "/allArticle", method = RequestMethod.GET)
    public List<ArticleModel> queryAllArticle(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return articleService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 图片新增
     *
     * @param: [photoModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:23
     */
    @RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
    public boolean addPhoto(PhotoModel photoModel) {
        return photoService.insert(photoModel);
    }

    /**
     * 功能描述: 图片更新
     *
     * @param: [photoModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:29
     */
    @RequestMapping(value = "/updatePhoto", method = RequestMethod.PUT)
    public boolean updatePhoto(@RequestBody PhotoModel photoModel) {
        return photoService.updateById(photoModel);
    }

    /**
     * 功能描述: 图片删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:37
     */
    @RequestMapping(value = "/deletePhoto/{id}", method = RequestMethod.DELETE)
    public boolean deletePhoto(@PathVariable(value = "id") Integer id) {
        return photoService.deleteById(id);
    }

    /**
     * 功能描述: 图片分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.PhotoModel>
     * @auther: darker
     * @date: 2018/7/20 15:46
     */
    @RequestMapping(value = "/allPhoto", method = RequestMethod.GET)
    public List<PhotoModel> queryAllPhoto(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return photoService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 留言新增
     *
     * @param: [messageModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:25
     */
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public boolean addMessage(MessageModel messageModel) {
        return messageService.insert(messageModel);
    }

    /**
     * 功能描述: 留言更新
     *
     * @param: [messageModel]
     * @return:
     * @auther: darker
     * @date: 2018/7/20 15:31
     */
    @RequestMapping(value = "/updateMessage", method = RequestMethod.PUT)
    public boolean updateMessage(@RequestBody MessageModel messageModel) {
        return messageService.updateById(messageModel);
    }

    /**
     * 功能描述: 留言删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:39
     */
    @RequestMapping(value = "/deleteMessage/{id}", method = RequestMethod.DELETE)
    public boolean deleteMessage(@PathVariable(value = "id") Integer id) {
        return messageService.deleteById(id);
    }

    /**
     * 功能描述: 留言分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MessageModel>
     * @auther: darker
     * @date: 2018/7/20 15:43
     */
    @RequestMapping(value = "/allMessage", method = RequestMethod.GET)
    public List<MessageModel> queryAllMessage(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return messageService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
