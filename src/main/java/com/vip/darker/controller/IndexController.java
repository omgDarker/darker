package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.*;
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
 * @description ：博客页面CONTROLLER
 * @date : 2018/7/17 11:05
 */
@RestController
@RequestMapping(value = "index")
public class IndexController {

    private static final String INDEX = "index";

    /**
     * 博客首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 返回页面
        ModelAndView modelAndView = new ModelAndView( INDEX + "/home" );
        // 文章<最新,降序排列>
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage( new Page<>( pageNum, pageSize ), new EntityWrapper<ArticleModel>().orderDesc( Collections.singletonList( "updateTime" ) ) ).getRecords();
        // 处理文章摘要长度
        for (ArticleModel model : list) {
            if (StringUtils.isNotBlank( model.getSummary() )) {
                if (StringUtils.isNotBlank( model.getImageName() )) {
                    // 若存在图片
                    model.setSummary( model.getSummary().substring( 0, model.getSummary().length() > 130 ? 130 : model.getSummary().length() ) );
                } else {
                    // 若不存在图片
                    model.setSummary( model.getSummary().substring( 0, model.getSummary().length() > 230 ? 230 : model.getSummary().length() ) );
                }
            }
        }
        // 文章<阅读排行,降序排列>
        List<ArticleModel> readAmountList = SystemServiceLocator.getArticleService().selectList( new EntityWrapper<ArticleModel>().orderDesc( Collections.singletonList( "readAmount" ) ).last( "LIMIT 5" ) );
        // 文章<点赞排行,降序排列>
        List<ArticleModel> likeAmountList = SystemServiceLocator.getArticleService().selectList( new EntityWrapper<ArticleModel>().orderDesc( Collections.singletonList( "likeAmount" ) ).last( "LIMIT 5" ) );
        // 文章总数
        int count = SystemServiceLocator.getArticleService().selectCount( new EntityWrapper<>() );
        // 所有栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        // 友情链接
        List<LinkModel> linkList = SystemServiceLocator.getLinkService().selectList( new EntityWrapper<>() );
        // 当前页
        modelAndView.addObject( "pageNum", pageNum );
        // 总页数
        modelAndView.addObject( "pageNumSum", (count - 1) / pageSize + 1 );
        // 总条数
        modelAndView.addObject( "numSum", count );
        // 文章<最新版>
        modelAndView.addObject( "list", list );
        // 文章<阅读排行>
        modelAndView.addObject( "readAmountList", readAmountList );
        // 文章<点赞排行>
        modelAndView.addObject( "likeAmountList", likeAmountList );
        // 栏目
        modelAndView.addObject( "columnList", columnList );
        // 链接
        modelAndView.addObject( "linkList", linkList );

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
    public ModelAndView getArticleDetail(@PathVariable(value = "id") Integer id) {
        // 返回页面
        ModelAndView modelAndView = new ModelAndView( INDEX + "/detail_article" );
        // 文章信息
        ArticleModel articleModel = SystemServiceLocator.getArticleService().selectById( id );
        // 留言信息
        List<MessageModel> messageModelList = SystemServiceLocator.getMessageService().selectList( new EntityWrapper<MessageModel>().where( "articleId={0}", id ) );
        // 文章<阅读排行,降序排列>
        List<ArticleModel> readAmountList = SystemServiceLocator.getArticleService().selectList( new EntityWrapper<ArticleModel>().orderDesc( Collections.singletonList( "readAmount" ) ).last( "LIMIT 5" ) );
        // 文章<点赞排行,降序排列>
        List<ArticleModel> likeAmountList = SystemServiceLocator.getArticleService().selectList( new EntityWrapper<ArticleModel>().orderDesc( Collections.singletonList( "likeAmount" ) ).last( "LIMIT 5" ) );
        // 文章总数
        int count = SystemServiceLocator.getArticleService().selectCount( new EntityWrapper<>() );
        // 栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        // 友情链接
        List<LinkModel> linkList = SystemServiceLocator.getLinkService().selectList( new EntityWrapper<>() );

        modelAndView.addObject( "article", articleModel );
        // 留言内容
        modelAndView.addObject( "messageList", messageModelList );
        // 文章<阅读排行>
        modelAndView.addObject( "readAmountList", readAmountList );
        // 文章<点赞排行>
        modelAndView.addObject( "likeAmountList", likeAmountList );
        // 栏目
        modelAndView.addObject( "columnList", columnList );
        // 链接
        modelAndView.addObject( "linkList", linkList );

        return modelAndView;
    }

    /**
     * 简介
     *
     * @return
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {

        ModelAndView modelAndView = new ModelAndView( INDEX + "/about" );
        // 栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        // 栏目
        modelAndView.addObject( "columnList", columnList );

        return modelAndView;
    }

    /**
     * 相册
     *
     * @return
     */
    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public ModelAndView getPhoto(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView( INDEX + "/photo" );
        // 获取所有图片名称
        List<PhotoModel> photoModelList = SystemServiceLocator.getPhotoService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
        // 所有栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        modelAndView.addObject( "photoList", photoModelList );
        modelAndView.addObject( "columnList", columnList );
        modelAndView.addObject( "pageNum", pageNum );

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
     * 功能描述: 查询栏目文章
     *
     * @param: [classify<大类></>, column<下拉框></>]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView getArticleByClassifyIdAndColumnId(@PathVariable(value = "classifyId") String classifyId, @PathVariable(value = "columnId") String columnId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView( INDEX + "/article" );
        // 文章总条数
        int count = SystemServiceLocator.getArticleService().selectCount( new EntityWrapper<ArticleModel>().where( "classifyId={0} ", classifyId ).and( "columnId={0}", columnId ) );
        // 根据条件查询文章
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage( new Page<>( pageNum, pageSize ), new EntityWrapper<ArticleModel>().where( "classifyId={0} ", classifyId ).and( "columnId={0}", columnId ) ).getRecords();
        // 所有栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        // 根据分类ID获取分类名称
        String classifyName = SystemServiceLocator.getClassifyService().selectById( classifyId ).getName();
        // 根据栏目ID获取栏目名称
        String columnName = SystemServiceLocator.getColumnService().selectById( columnId ).getName();
        // 数据
        modelAndView.addObject( "list", list );
        // 分类ID
        modelAndView.addObject( "classifyId", classifyId );
        // 分类名称
        modelAndView.addObject( "classifyName", classifyName );
        // 栏目ID
        modelAndView.addObject( "columnId", columnId );
        // 栏目名称
        modelAndView.addObject( "columnName", columnName );
        // 栏目
        modelAndView.addObject( "columnList", columnList );
        // 当前页
        modelAndView.addObject( "pageNum", pageNum );
        // 总页数
        modelAndView.addObject( "pageNumSum", (count - 1) / pageSize + 1 );
        // 总条数
        modelAndView.addObject( "numSum", count );

        return modelAndView;
    }

    /**
     * 功能描述: 查询分类文章
     *
     * @param: [classify<大类>]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/13 22:39
     */
    @RequestMapping(value = "/article/{classifyId}", method = RequestMethod.GET)
    public ModelAndView getArticleByClassifyId(@PathVariable(value = "classifyId") String classifyId, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView( INDEX + "/article" );
        // 文章总条数
        int count = SystemServiceLocator.getArticleService().selectCount( new EntityWrapper<ArticleModel>().where( "classifyId={0} ", classifyId ) );
        // 根据条件查询文章
        List<ArticleModel> list = SystemServiceLocator.getArticleService().selectPage( new Page<>( pageNum, pageSize ), new EntityWrapper<ArticleModel>().where( "classifyId={0} ", classifyId ) ).getRecords();
        // 处理文章摘要长度
        for (ArticleModel model : list) {
            if (StringUtils.isNotBlank( model.getSummary() )) {
                model.setSummary( model.getSummary().substring( 0, model.getSummary().length() > 130 ? 130 : model.getSummary().length() ) );
            }
        }
        // 根据分类ID获取分类名称
        String classifyName = SystemServiceLocator.getClassifyService().selectById( classifyId ).getName();
        // 所有栏目
        List<ColumnModel> columnList = SystemServiceLocator.getColumnService().selectList( new EntityWrapper<>() );
        // 数据
        modelAndView.addObject( "list", list );
        // 分类ID
        modelAndView.addObject( "classifyId", classifyId );
        // 分类名称
        modelAndView.addObject( "classifyName", classifyName );
        // 栏目
        modelAndView.addObject( "columnList", columnList );
        // 当前页
        modelAndView.addObject( "pageNum", pageNum );
        // 总页数
        modelAndView.addObject( "pageNumSum", (count - 1) / pageSize + 1 );
        // 总条数
        modelAndView.addObject( "numSum", count );

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
        ModelAndView modelAndView = new ModelAndView( INDEX + "/message" );
        // 查询所有留言信息
        List<MessageModel> messageModelList = SystemServiceLocator.getMessageService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();

        modelAndView.addObject( "pageNum", pageNum );
        modelAndView.addObject( "messageList", messageModelList );

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

        articleModel.setId( id );
        articleModel.setLikeAmount( likeAmount + 1 );

        Map<String, Object> map = new HashMap<>();

        boolean flag = SystemServiceLocator.getArticleService().updateById( articleModel );

        map.put( Constant.MSG, flag ? Constant.SUCCESS : Constant.FAIL );
        map.put( "likeAmount", likeAmount + 1 );

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

        articleModel.setId( id );
        articleModel.setLikeNoAmount( likeNoAmount + 1 );

        Map<String, Object> map = new HashMap<>();

        boolean flag = SystemServiceLocator.getArticleService().updateById( articleModel );

        map.put( Constant.MSG, flag ? Constant.SUCCESS : Constant.FAIL );
        map.put( "likeNoAmount", likeNoAmount + 1 );

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
        return new ModelAndView( "error/index_404" );
    }
}
