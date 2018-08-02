package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.DiaryModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 15:05
 * @Description: 内容管理Controller
 */
@RestController
@RequestMapping(value = "content")
public class ContentController {

    /**
     * 功能描述:日志新增
     *
     * @param: [diaryModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:20
     */
    @RequestMapping(value = "/addDiary", method = RequestMethod.POST)
    public Map<String, Object> addDiary(DiaryModel diaryModel) {

        boolean flag = SystemServiceLocator.getDiaryService().insert(diaryModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
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
    public Map<String, Object> updateDiary(DiaryModel diaryModel) {

        boolean flag = SystemServiceLocator.getDiaryService().updateById(diaryModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
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
    public Map<String, Object> deleteDiary(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getDiaryService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 日记实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.DiaryModel
     * @auther: darker
     * @date: 2018/8/1 16:49
     */
    @RequestMapping(value = "/allDiary/{id}", method = RequestMethod.GET)
    public DiaryModel queryDiaryById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getDiaryService().selectById(id);
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
    public List<DiaryModel> queryAllDiary(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getDiaryService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 日记分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/diaryMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getDiaryMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getDiaryService().selectCount(new EntityWrapper<>());

        map.put("diaryMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
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
    public Map<String, Object> addArticle(ArticleModel articleModel) {

        boolean flag = SystemServiceLocator.getArticleService().insert(articleModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

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

        boolean flag = SystemServiceLocator.getArticleService().updateById(articleModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

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

        boolean flag = SystemServiceLocator.getArticleService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 文章分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/articleMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getArticleMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getArticleService().selectCount(new EntityWrapper<>());

        map.put("articleMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * 功能描述: 文章实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ArticleModel
     * @auther: darker
     * @date: 2018/8/1 16:49
     */
    @RequestMapping(value = "/allArticle/{id}", method = RequestMethod.GET)
    public ArticleModel queryArticleById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getArticleService().selectById(id);
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
    public List<ArticleModel> queryAllArticle(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getArticleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
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
        return SystemServiceLocator.getPhotoService().insert(photoModel);
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
        return SystemServiceLocator.getPhotoService().updateById(photoModel);
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
        return SystemServiceLocator.getPhotoService().deleteById(id);
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
    public List<PhotoModel> queryAllPhoto(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
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
        return SystemServiceLocator.getMessageService().insert(messageModel);
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
        return SystemServiceLocator.getMessageService().updateById(messageModel);
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
        return SystemServiceLocator.getMessageService().deleteById(id);
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
    public List<MessageModel> queryAllMessage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
