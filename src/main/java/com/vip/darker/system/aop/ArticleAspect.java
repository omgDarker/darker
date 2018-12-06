package com.vip.darker.system.aop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: Darker
 * @description ：：监控文章模块浏览量信息统计
 * @date : 2018/8/31 11:32
 */
@Aspect
@Component
public class ArticleAspect {

    // 申明切点,监控文章详情页方法
    @Pointcut(value = "execution(public * com.vip.darker.controller.ArticleController.findDetailArticle(*))")
    public void updatePV() {

    }

    // 申明切点,监控文章更新方法
    @Pointcut(value = "execution(* *Article(..))")
    public void deleteCache() {

    }

    /**
     * 功能描述: 更新文章PV
     *
     * @param: [point]
     * @auther: darker
     * @date: 2018/9/25 16:18
     */
    @After(value = "updatePV()")
    public void doAfter(JoinPoint point) {
        // 获取文章ID
        int articleId = Integer.valueOf(point.getArgs()[0].toString());
        // 查询当前文章浏览量值
        Map<String, Object> map = SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleModel>().where("id={0}", articleId));
        // 浏览量+1,持久化到DB
        ArticleModel articleModel = new ArticleModel();
        articleModel.setId(articleId);
        articleModel.setReadAmount(Integer.valueOf(map.get("readAmount").toString()) + 1);
        SpringBootService.getArticleService().updateById(articleModel);
        // 清空redis缓存
        SpringBootService.getRedisService().delKey(new String[]{Constant.REDIS_KEY_ARTICLE});
    }

    /**
     * 功能描述: 文章缓存清空
     *
     * @param: [point]
     * @auther: darker
     * @date: 2018/9/25 16:18
     */
    @After(value = "deleteCache()")
    public void deleteCache(JoinPoint point) {
        SpringBootService.getRedisService().delKey(new String[]{Constant.REDIS_KEY_ARTICLE});
    }
}
