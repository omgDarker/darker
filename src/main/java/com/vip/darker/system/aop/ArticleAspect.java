package com.vip.darker.system.aop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: Darker
 * @description ：文章浏览量信息统计
 * @date : 2018/8/31 11:32
 */
@Aspect
@Component
public class ArticleAspect {

    // 申明切点,监控文章详情页方法
    @Pointcut(value = "execution(public * com.vip.darker.controller.IndexController.getArticleDetail(*))")
    public void article() {

    }

    @After(value = "article()")
    public void doAfter(JoinPoint point) {
        // 获取文章ID
        int articleId = Integer.valueOf(point.getArgs()[0].toString());
        // 查询当前文章浏览量值
        Map<String, Object> map = SystemServiceLocator.getArticleService().selectMap(new EntityWrapper<ArticleModel>().where("id={0}", articleId));
        // 浏览量+1,持久化到DB
        ArticleModel articleModel = new ArticleModel();
        articleModel.setId(articleId);
        articleModel.setReadAmount(Integer.valueOf(map.get("readAmount").toString()) + 1);
        SystemServiceLocator.getArticleService().updateById(articleModel);
    }
}
