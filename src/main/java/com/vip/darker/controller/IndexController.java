package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.ConvertAttribute;
import com.vip.darker.util.WebSiteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @Auther: Darker
 * @description ：博客首页控制器
 * @date : 2018/7/17 11:05
 */
@RestController
@RequestMapping(value = IndexController.INDEX)
public class IndexController {

    static final String INDEX = "index";

    /**
     * 功能描述: 博客首页
     *
     * @param: [pageSize, pageNum]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/10 16:49
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @SuppressWarnings(value = "unchecked")
    public ModelAndView index(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(INDEX + "/home");
        // redis中取文章列表
        List<ArticleModel> list = Optional.ofNullable((List<ArticleModel>) SpringBootService.getRedisService().get(Constant.REDIS_KEY_ARTICLE))
                .map(opt -> opt.subList((pageNum - 1) * pageSize, pageNum * pageSize > opt.size() ? opt.size() : pageNum * pageSize))
                .orElse(SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("updateTime"))).getRecords());

        list.forEach(model -> {
            // 处理文章摘要长度
            String summary = model.getSummary();
            if (StringUtils.isNotBlank(summary)) {
                if (StringUtils.isNotBlank(model.getImageName())) {
                    // 若存在图片
                    model.setSummary(summary.substring(0, summary.length() > 90 ? 90 : summary.length()));
                }
            }
            // 文章栏目信息
            String columnName = Optional.ofNullable(model.getColumnId())
                    .map(opt -> ConvertAttribute.getColumnMap().get(Integer.valueOf(opt)))
                    .orElse("其他类型");
            model.setColumnName(columnName);
        });
        // 文章总数
        int numSum = SpringBootService.getArticleService().selectCount(new EntityWrapper<>());
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (numSum - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", numSum);
        // 文章列表
        modelAndView.addObject("list", list);
        // 网站右侧信息列表
        WebSiteUtil.getWebOffsideInformation(modelAndView);

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
    @RequestMapping(value = "/article/detail/{id}", method = RequestMethod.GET)
    public ModelAndView findDetailArticle(@PathVariable(value = "id") Integer id) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(INDEX + "/article_detail");
        // 文章信息
        ArticleModel articleModel = SpringBootService.getArticleService().selectById(id);
        // 设置文章栏目名称
        String columnName = Optional.ofNullable(articleModel.getColumnId())
                .map(opt -> ConvertAttribute.getColumnMap().get(Integer.valueOf(opt)))
                .orElse("其他类型");
        articleModel.setColumnName(columnName);
        // 重置summary
        if ("<p></p>".equals(WebSiteUtil.replaceBlank(articleModel.getSummary()))) {
            articleModel.setSummary("");
        }
        modelAndView.addObject("object", articleModel);
        // 文章总数
        modelAndView.addObject("numSum", SpringBootService.getArticleService().selectCount(new EntityWrapper<>()));
        // 留言内容
        modelAndView.addObject("messageList", SpringBootService.getMessageService().selectList(new EntityWrapper<MessageModel>().where("articleId={0}", id)));
        // 网站右侧信息列表
        WebSiteUtil.getWebOffsideInformation(modelAndView);

        return modelAndView;
    }

    /**
     * 功能描述: 关于我
     *
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView(INDEX + "/about");
        return modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
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
    public ModelAndView findPhotoByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId", required = false) Integer columnId) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/photo");
        // 图片列表
        modelAndView.addObject("photoList", SpringBootService.getPhotoService().selectList(new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
        // 栏目名称
        modelAndView.addObject("columnName", ConvertAttribute.getColumnMap().getOrDefault(columnId, "其他栏目"));

        return modelAndView;
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
    public ModelAndView findPhotoByClassifyId(@PathVariable(value = "classifyId") Integer classifyId) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/photo");
        // 图片列表
        modelAndView.addObject("photoList", SpringBootService.getPhotoService().selectList(new EntityWrapper<PhotoModel>().where("classifyId={0} ", classifyId)));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());

        return modelAndView;
    }

    /**
     * 功能描述: 生活点滴、技术联盟
     *
     * @param: [classify column]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView findArticleByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId") Integer columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/article");
        // 文章总条数
        int count = SpringBootService.getArticleService().selectCount(new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId));
        // 文章列表
        modelAndView.addObject("list", SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)).getRecords());
        // 分类ID
        modelAndView.addObject("classifyId", classifyId);
        // 分类名称
        modelAndView.addObject("classifyName", ConvertAttribute.getClassifyMap().getOrDefault(classifyId, "其他分类"));
        // 栏目ID
        modelAndView.addObject("columnId", columnId);
        // 栏目名称
        modelAndView.addObject("columnName", ConvertAttribute.getColumnMap().getOrDefault(columnId, "其他栏目"));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (count - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", count);

        return modelAndView;
    }

    /**
     * 功能描述: 生活点滴、技术联盟
     *
     * @param: [classify]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}", method = RequestMethod.GET)
    public ModelAndView findArticleByClassifyId(@PathVariable(value = "classifyId") Integer classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView(INDEX + "/article");
        // 文章总条数
        int count = SpringBootService.getArticleService().selectCount(new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId));
        // 根据条件查询文章
        List<ArticleModel> list = SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleModel>().where("classifyId={0} ", classifyId)).getRecords();
        // 处理文章简介长度
        list.forEach(opt -> {
            Optional<String> optional = Optional.ofNullable(opt.getSummary());
            if (optional.isPresent()) {
                opt.setSummary(opt.getSummary().substring(0, opt.getSummary().length() > 130 ? 130 : opt.getSummary().length()));
            }
        });
        // 文章列表
        modelAndView.addObject("list", list);
        // 分类ID
        modelAndView.addObject("classifyId", classifyId);
        // 分类名称
        modelAndView.addObject("classifyName", ConvertAttribute.getClassifyMap().getOrDefault(classifyId, "其他分类"));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (count - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", count);

        return modelAndView;
    }

    /**
     * 功能描述: 留言板
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
        modelAndView.addObject("messageList", SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords());
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());

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

        map.put(Constant.MSG, SpringBootService.getArticleService().updateById(articleModel) ? Constant.SUCCESS : Constant.FAIL);
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

        map.put(Constant.MSG, SpringBootService.getArticleService().updateById(articleModel) ? Constant.SUCCESS : Constant.FAIL);
        map.put("likeNoAmount", likeNoAmount + 1);

        return map;
    }
}