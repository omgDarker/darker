package com.vip.darker.system.aop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.entity.ArticleDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.ConfigConstant;
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
     * @description:更新文章PV
     * @auther: WBA
     * @date: 2018/12/11 17:03
     * @param: [point]
     * @return: void
     */
    @After(value = "updatePV()")
    public void doAfter(JoinPoint point) {
        // 获取文章ID
        int articleId = Integer.valueOf(point.getArgs()[0].toString());
        // 查询当前文章浏览量值
        Map<String, Object> map = SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleDO>().where("id={0}", articleId));
        // 浏览量+1,持久化到DB
        ArticleDO articleDO = new ArticleDO();
        articleDO.setId(articleId);
        articleDO.setReadAmount(Integer.valueOf(map.get("readAmount").toString()) + 1);
        SpringBootService.getArticleService().updateById(articleDO);
        // 清空redis缓存
        SpringBootService.getRedisService().delKey(new String[]{ConfigConstant.REDIS_KEY_ARTICLE});
    }

    /**
     * @description:文章缓存清空
     * @auther: WBA
     * @date: 2018/12/11 17:03
     * @param: [point]
     * @return: void
     */
    @After(value = "deleteCache()")
    public void deleteCache(JoinPoint point) {
        SpringBootService.getRedisService().delKey(new String[]{ConfigConstant.REDIS_KEY_ARTICLE});
    }
}
