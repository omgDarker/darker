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
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: Darker
 * @description ：文章控制器
 * @date : 2018/12/06 10:41
 */
@RestController
public class ArticleController {

    //****************************************文章模块****************************************//

    /**
     * 功能描述: 文章新增
     *
     * @param: [articleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:22
     */
    @RequestMapping(value = "/articles", method = RequestMethod.POST)
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
    @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    public Map<String, Object> editArticle(ArticleModel articleModel) {

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
    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
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
    @RequestMapping(value = "/articles/page", method = RequestMethod.GET)
    public Map<String, Object> countArticlePage() {

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
    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public List<ArticleModel> findListArticle(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        List<ArticleModel> list = SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();

        list.forEach(opt -> {
            opt.setClassifyName(ConvertAttribute.getClassifyMap().get(opt.getClassifyId()));
            opt.setColumnName(ConvertAttribute.getColumnMap().get(opt.getColumnId()));
        });

        return list;
    }

    /**
     * 功能描述: 文章详情页
     *
     * @param: [id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/8/10 16:49
     */
    @RequestMapping(value = "/articles/detail/{id}", method = RequestMethod.GET)
    public ModelAndView findDetailArticle(@PathVariable(value = "id") Integer id) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView("home/article_detail");
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
     * 功能描述: 点赞功能
     *
     * @param: [id, likeAmount]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/20 16:32
     */
    @RequestMapping(value = "/articles/like/{id}", method = RequestMethod.POST)
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
    @RequestMapping(value = "/articles/likeNo/{id}", method = RequestMethod.POST)
    public Map<String, Object> addLikeNo(@PathVariable(value = "id") Integer id, @RequestParam(value = "likeNoAmount") Integer likeNoAmount) {

        ArticleModel articleModel = new ArticleModel();

        articleModel.setId(id);
        articleModel.setLikeNoAmount(likeNoAmount + 1);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, SpringBootService.getArticleService().updateById(articleModel) ? Constant.SUCCESS : Constant.FAIL);
        map.put("likeNoAmount", likeNoAmount + 1);

        return map;
    }

    /**
     * 功能描述: 生活点滴、技术联盟
     *
     * @param: [classify column]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/home/articles/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView findArticleByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId") Integer columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView("home/article");
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
    @RequestMapping(value = "/home/articles/{classifyId}", method = RequestMethod.GET)
    public ModelAndView findArticleByClassifyId(@PathVariable(value = "classifyId") Integer classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView( "home/article");
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
}