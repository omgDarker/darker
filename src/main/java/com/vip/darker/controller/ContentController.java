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
 * @DateUpdate: 2018/8/2
 * @Description: 内容管理Controller
 */
@RestController
@RequestMapping(value = "content")
public class ContentController {

    //****************************************日志模块****************************************//

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

        boolean flag = SystemServiceLocator.getDiaryService().insert( diaryModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

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

        boolean flag = SystemServiceLocator.getDiaryService().updateById( diaryModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

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

        boolean flag = SystemServiceLocator.getDiaryService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

        return map;
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

        int count = SystemServiceLocator.getDiaryService().selectCount( new EntityWrapper<>() );

        map.put( "diaryMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

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
        return SystemServiceLocator.getDiaryService().selectById( id );
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
        return SystemServiceLocator.getDiaryService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

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

        boolean flag = SystemServiceLocator.getArticleService().insert( articleModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

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

        boolean flag = SystemServiceLocator.getArticleService().updateById( articleModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

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

        boolean flag = SystemServiceLocator.getArticleService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

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

        int count = SystemServiceLocator.getArticleService().selectCount( new EntityWrapper<>() );

        map.put( "articleMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

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
        return SystemServiceLocator.getArticleService().selectById( id );
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
        return SystemServiceLocator.getArticleService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    //****************************************图片模块****************************************//

    /**
     * 功能描述: 图片新增
     *
     * @param: [photoModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:23
     */
    @RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
    public Map<String, Object> addPhoto(PhotoModel photoModel) {

        boolean flag = SystemServiceLocator.getPhotoService().insert( photoModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

        return map;
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
    public Map<String, Object> updatePhoto(PhotoModel photoModel) {

        boolean flag = SystemServiceLocator.getPhotoService().updateById( photoModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

        return map;
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
    public Map<String, Object> deletePhoto(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getPhotoService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

        return map;
    }

    /**
     * 功能描述: 照片分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/2 22:56
     */
    @RequestMapping(value = "/photoMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getPhotoMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getPhotoService().selectCount( new EntityWrapper<>() );

        map.put( "photoMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return map;
    }

    /**
     * 功能描述: 图片实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.PhotoModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/allPhoto/{id}", method = RequestMethod.GET)
    public PhotoModel queryPhotoById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getPhotoService().selectById( id );
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
        return SystemServiceLocator.getPhotoService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    //****************************************留言板模块****************************************//

    /**
     * 功能描述: 留言新增
     *
     * @param: [messageModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:25
     */
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public Map<String, Object> addMessage(MessageModel messageModel) {

        boolean flag = SystemServiceLocator.getMessageService().insert( messageModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

        return map;
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
    public Map<String, Object> updateMessage(MessageModel messageModel) {

        boolean flag = SystemServiceLocator.getMessageService().updateById( messageModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

        return map;
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
    public Map<String, Object> deleteMessage(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getMessageService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

        return map;
    }

    /**
     * 功能描述: 照片分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/2 22:56
     */
    @RequestMapping(value = "/messageMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getMessageMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getMessageService().selectCount( new EntityWrapper<>() );

        map.put( "messageMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return map;
    }

    /**
     * 功能描述: 图片实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.MessageModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/allMessage/{id}", method = RequestMethod.GET)
    public MessageModel queryMessageById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getMessageService().selectById( id );
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
        return SystemServiceLocator.getMessageService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }
}
