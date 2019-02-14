package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.constant.CommonConstant;
import com.vip.darker.entity.ArticleDO;
import com.vip.darker.entity.UserDO;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 16:03
 * @Description: 监控统计控制器
 */
@RestController
@RequestMapping(value = "operation")
public class OperationContorller {

    /**
     * @description:查询统计信息列表
     * @auther: WBA
     * @date: 2018/12/11 16:57
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public Map<String, Object> findListStatistics() {
        // 设置参数
        Map<String, Object> map = new HashMap<>(CommonConstant.MAP_DEFAULT_INITIAL_CAPACITY);
        // 统计访问量
        map.put("countWebVV", SpringBootService.getUserService().selectList(new EntityWrapper<>()).size());
        // 统计浏览量
        map.put("countWebPV", SpringBootService.getPropertiesStat().getCountPV());
        // 统计用户数*
        map.put("countWebUV", SpringBootService.getUserService().selectList(new EntityWrapper<UserDO>().setSqlSelect("distinct ip")).size());
        // 统计留言数
        map.put("countMessage", SpringBootService.getMessageService().selectCount(new EntityWrapper<>()));
        // 统计友链数
        map.put("countLink", SpringBootService.getLinkService().selectCount(new EntityWrapper<>()));
        // 统计文章数
        map.put("countArticle", SpringBootService.getArticleService().selectCount(new EntityWrapper<>()));
        // 统计图片数
        map.put("countimage", SpringBootService.getImageService().selectCount(new EntityWrapper<>()));
        // 统计点赞数*
        map.put("countLike", SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleDO>().setSqlSelect("sum(likeAmount) as amount")).get("amount"));
        // 统计甩鞋数
        map.put("countLikeNo", SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleDO>().setSqlSelect("sum(likeNoAmount) as amount ")).get("amount"));

        return map;
    }
}