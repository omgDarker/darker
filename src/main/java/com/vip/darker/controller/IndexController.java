package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.ColumnModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @description ：博客首页控制器
 * @date : 2018/7/17 11:05
 */
@RestController
@RequestMapping(value = "index")
public class IndexController {

    private static final String INDEX = "index";

    /**
     * 功能描述: 博客首页
     *
     * @param: [pageSize, pageNum]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/10 16:49
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(INDEX + "/home");
        // 文章<最新,降序排列>
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("updateTime"))).getRecords();

        for (ArticleModel model : list) {
            // 处理文章摘要长度
            if (StringUtils.isNotBlank(model.getSummary())) {
                if (StringUtils.isNotBlank(model.getImageName())) {
                    // 若存在图片
                    model.setSummary(model.getSummary().substring(0, model.getSummary().length() > 90 ? 90 : model.getSummary().length()));
                }
            }
            // 获取文章栏目
            if (StringUtils.isNotBlank(model.getColumnId())) {
                model.setColumnName(SystemServiceLocator.getColumnService().selectMap(new EntityWrapper<ColumnModel>().where("id={0}", model.getColumnId())).get("name") + "");
            }
        }

        // 文章总数
        int numSum = SystemServiceLocator.getArticleService().selectCount(new EntityWrapper<>());
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (numSum - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", numSum);
        // 文章列表<最新版>
        modelAndView.addObject("list", list);
        // 获取网站右侧信息
        getWebOffsideInformation(modelAndView);

        return modelAndView;
    }

    /**
     * 功能描述: 文章详情页
     *
     * @param: [id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/10 16:49
     */
    @RequestMapping(value = "/detail/article/{id}", method = RequestMethod.GET)
    public ModelAndView getArticleDetail(@PathVariable(value = "id") Integer id) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(INDEX + "/detail_article");
        // 文章信息
        ArticleModel articleModel = SystemServiceLocator.getArticleService().selectById(id);
        articleModel.setColumnName(SystemServiceLocator.getColumnService().selectMap(new EntityWrapper<ColumnModel>().where("id={0}", articleModel.getColumnId())).get("name") + "");
        modelAndView.addObject("object", articleModel);
        // 文章总数
        modelAndView.addObject("numSum", SystemServiceLocator.getArticleService().selectCount(new EntityWrapper<>()));
        // 留言内容
        modelAndView.addObject("messageList", SystemServiceLocator.getMessageService().selectList(new EntityWrapper<MessageModel>().where("articleId={0}", id)));
        // 获取网站右侧信息
        getWebOffsideInformation(modelAndView);

        return modelAndView;
    }

    /**
     * 功能描述: 个人介绍
     *
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/about");
        // 查询栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));

        return modelAndView;
    }

    /**
     * 功能描述: 视觉冲击
     *
     * @param: [classify, column]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/photo/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView getPhotoByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId", required = false) Integer columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/photo");
        // 图片列表
        modelAndView.addObject("photoList", SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)).getRecords());
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("columnId", columnId);
        // 栏目名称
        modelAndView.addObject("columnName", SystemServiceLocator.getColumnService().selectById(columnId).getName());

        return modelAndView;
    }

    /**
     * 功能描述: 视觉冲击-翻页操作
     *
     * @param: [classify, column]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/photo/turn/{classifyId}/{columnId}", method = RequestMethod.GET)
    public List<PhotoModel> getMorePhotoByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId", required = false) Integer columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        return SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)).getRecords();
    }

    /**
     * 功能描述: 视觉冲击
     *
     * @param: [classify]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/photo/{classifyId}", method = RequestMethod.GET)
    public ModelAndView getPhotoByClassifyId(@PathVariable(value = "classifyId") Integer classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/photo");
        // 图片列表
        modelAndView.addObject("photoList", SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId)).getRecords());
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));
        // 当前页
        modelAndView.addObject("pageNum", pageNum);

        return modelAndView;
    }

    /**
     * 功能描述: 视觉冲击-翻页操作
     *
     * @param: [classify]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/photo/turn/{classifyId}", method = RequestMethod.GET)
    public List<PhotoModel> getMorePhotoByClassifyId(@PathVariable(value = "classifyId") Integer classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        return SystemServiceLocator.getPhotoService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId)).getRecords();
    }

    /**
     * 功能描述: 文章查询
     *
     * @param: [classify column]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView getArticleByClassifyIdAndColumnId(@PathVariable(value = "classifyId") String classifyId, @PathVariable(value = "columnId") String columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/article");
        // 文章总条数
        int count = SystemServiceLocator.getArticleService().selectCount(new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId));
        // 文章列表
        modelAndView.addObject("list", SystemServiceLocator.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)).getRecords());
        // 分类ID
        modelAndView.addObject("classifyId", classifyId);
        // 分类名称
        modelAndView.addObject("classifyName", SystemServiceLocator.getClassifyService().selectById(classifyId).getName());
        // 栏目ID
        modelAndView.addObject("columnId", columnId);
        // 栏目名称
        modelAndView.addObject("columnName", SystemServiceLocator.getColumnService().selectById(columnId).getName());
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (count - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", count);

        return modelAndView;
    }

    /**
     * 功能描述: 文章分类查询
     *
     * @param: [classify]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}", method = RequestMethod.GET)
    public ModelAndView getArticleByClassifyId(@PathVariable(value = "classifyId") String classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/article");
        // 文章总条数
        int count = SystemServiceLocator.getArticleService().selectCount(new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId));
        // 根据条件查询文章
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId)).getRecords();
        // 处理文章摘要长度
        for (ArticleModel model : list) {
            if (StringUtils.isNotBlank(model.getSummary())) {
                model.setSummary(model.getSummary().substring(0, model.getSummary().length() > 130 ? 130 : model.getSummary().length()));
            }
        }
        // 文章列表
        modelAndView.addObject("list", list);
        // 分类ID
        modelAndView.addObject("classifyId", classifyId);
        // 分类名称
        modelAndView.addObject("classifyName", SystemServiceLocator.getClassifyService().selectById(classifyId).getName());
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (count - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", count);

        return modelAndView;
    }

    /**
     * 功能描述: 留言板查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView message(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(INDEX + "/message");
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 留言列表
        modelAndView.addObject("messageList", SystemServiceLocator.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords());
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));

        return modelAndView;
    }

    /**
     * 功能描述: 点赞功能
     *
     * @param: [id, likeAmount]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/20 16:32
     */
    @RequestMapping(value = "/addLike/{id}", method = RequestMethod.POST)
    public Map<String, Object> addLike(@PathVariable(value = "id") Integer id, @RequestParam(value = "likeAmount") Integer likeAmount) {

        ArticleModel articleModel = new ArticleModel();

        articleModel.setId(id);
        articleModel.setLikeAmount(likeAmount + 1);

        Map<String, Object> map = new HashMap<>();

        boolean flag = SystemServiceLocator.getArticleService().updateById(articleModel);

        map.put(Constant.MSG, flag ? Constant.SUCCESS : Constant.FAIL);
        map.put("likeAmount", likeAmount + 1);

        return map;
    }

    /**
     * 功能描述: 甩鞋功能
     *
     * @param: [id, likeNoAmount]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/20 16:32
     */
    @RequestMapping(value = "/addNoLike/{id}", method = RequestMethod.POST)
    public Map<String, Object> addNoLike(@PathVariable(value = "id") Integer id, @RequestParam(value = "likeNoAmount") Integer likeNoAmount) {

        ArticleModel articleModel = new ArticleModel();

        articleModel.setId(id);
        articleModel.setLikeNoAmount(likeNoAmount + 1);

        Map<String, Object> map = new HashMap<>();

        boolean flag = SystemServiceLocator.getArticleService().updateById(articleModel);

        map.put(Constant.MSG, flag ? Constant.SUCCESS : Constant.FAIL);
        map.put("likeNoAmount", likeNoAmount + 1);

        return map;
    }

    /**
     * 功能描述: 错误页面404
     *
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/17 17:59
     */
    @RequestMapping(value = "/error/404")
    public ModelAndView errorPage() {
        return new ModelAndView("404");
    }

    /**
     * 功能描述: 获取网站右侧信息
     *
     * @param: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/9/4 18:00
     */
    private void getWebOffsideInformation(ModelAndView modelAndView) {
        // 栏目列表
        modelAndView.addObject("columnList", SystemServiceLocator.getColumnService().selectList(new EntityWrapper<>()));
        // 网站累计浏览量
        modelAndView.addObject("countPV", SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV());
        // 友情列表
        modelAndView.addObject("linkList", SystemServiceLocator.getLinkService().selectList(new EntityWrapper<>()));
        // 图片列表
        modelAndView.addObject("photoList", SystemServiceLocator.getPhotoService().selectList(new EntityWrapper<PhotoModel>().ne("columnId", "9")));
        // 文章列表<阅读排行>
        modelAndView.addObject("readAmountList", SystemServiceLocator.getArticleService().selectList(new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("readAmount")).last("LIMIT 5")));
        // 文章列表<博主推荐>
        modelAndView.addObject("likeAmountList", SystemServiceLocator.getArticleService().selectList(new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("likeAmount")).last("LIMIT 5")));
    }
}
