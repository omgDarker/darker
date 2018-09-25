package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.*;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.BeanToMapUtil;
import com.vip.darker.util.ConstantUtil;
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

        boolean flag = SpringBootService.getArticleService().insert(articleModel);

        Map<String, Object> map = new HashMap<>();

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_INSERT : ConstantUtil.FAIL_INSERT);

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

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_UPDATE : ConstantUtil.FAIL_UPDATE);

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

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_DELETE : ConstantUtil.FAIL_DELETE);

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

        int count = SpringBootService.getArticleService().selectCount(new EntityWrapper<>());

        map.put("articleMaxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

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
        return SpringBootService.getArticleService().selectById(id);
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
    public List<Map<String, Object>> queryArticleList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        List<ArticleModel> list = SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();

        try {
            // BEAN转MAP
            List<Map<String, Object>> resultList = BeanToMapUtil.convertListBeanToListMap(list, ArticleModel.class);

            for (Map<String, Object> map : resultList) {
                Map<String, Object> columnMap = SpringBootService.getColumnService().selectMap(new EntityWrapper<ColumnModel>().where("id={0}", map.get("columnId")));
                Map<String, Object> classifyMap = SpringBootService.getClassifyService().selectMap(new EntityWrapper<ClassifyModel>().where("id={0}", map.get("classifyId")));
                map.put("columnName", columnMap.get("name"));
                map.put("classifyName", classifyMap.get("name"));
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

        boolean flag = SpringBootService.getPhotoService().insert(photoModel);

        Map<String, Object> map = new HashMap<>();

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_INSERT : ConstantUtil.FAIL_INSERT);

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

        boolean flag = SpringBootService.getPhotoService().updateById(photoModel);

        Map<String, Object> map = new HashMap<>();

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_UPDATE : ConstantUtil.FAIL_UPDATE);

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

        boolean flag = SpringBootService.getPhotoService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_DELETE : ConstantUtil.FAIL_DELETE);

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

        int count = SpringBootService.getPhotoService().selectCount(new EntityWrapper<>());

        map.put("photoMaxPage", (count - 1) / (ConstantUtil.PAGE_SIZE + 2) + 1);

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
        return SpringBootService.getPhotoService().selectById(id);
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
    public List<PhotoModel> queryAllPhoto(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        return SpringBootService.getPhotoService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
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

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_UPDATE : ConstantUtil.FAIL_UPDATE);

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

        map.put(ConstantUtil.MSG, flag ? ConstantUtil.SUCCESS_DELETE : ConstantUtil.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 留言板分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/2 22:56
     */
    @RequestMapping(value = "/messageMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getMessageMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getMessageService().selectCount(new EntityWrapper<>());

        map.put("messageMaxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

        return map;
    }

    /**
     * 功能描述: 留言板实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.MessageModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/allMessage/{id}", method = RequestMethod.GET)
    public MessageModel queryMessageById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getMessageService().selectById(id);
    }

    /**
     * 功能描述: 留言板分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MessageModel>
     * @auther: darker
     * @date: 2018/7/20 15:43
     */
    @RequestMapping(value = "/allMessage", method = RequestMethod.GET)
    public List<MessageModel> queryAllMessage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
