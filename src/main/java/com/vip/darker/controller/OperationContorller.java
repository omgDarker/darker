package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.MonitorModel;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 16:03
 * @Description: 监控统计控制器
 */
@RestController
@RequestMapping(value = "operation")
public class OperationContorller {

    //****************************************统计模块****************************************//

    /**
     * 功能描述: 统计新增
     *
     * @param: [statisticsModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:09
     */
    @RequestMapping(value = "/addStatistics", method = RequestMethod.POST)
    public boolean addStatistics(StatisticsModel statisticsModel) {
        return SpringBootService.getStatisticsService().insert(statisticsModel);
    }

    /**
     * 功能描述: 统计删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:13
     */
    @RequestMapping(value = "/deleteStatistics/{id}", method = RequestMethod.DELETE)
    public boolean deleteStatistics(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getStatisticsService().deleteById(id);
    }

    /**
     * 功能描述: 统计更新
     *
     * @param: [statisticsModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:38
     */
    @RequestMapping(value = "/updateStatistics", method = RequestMethod.PUT)
    public boolean updateStatistics(StatisticsModel statisticsModel) {
        return SpringBootService.getStatisticsService().updateById(statisticsModel);
    }

    /**
     * 功能描述: 统计分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.StatisticsModel>
     * @auther: darker
     * @date: 2018/7/20 16:41
     */
    @RequestMapping(value = "/queryAllStatistics", method = RequestMethod.GET)
    public List<StatisticsModel> queryAllStatistics(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getStatisticsService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 查询统计信息列表
     *
     * @return: [map]
     * @auther: darker
     * @date: 2018/9/13 18:14
     */
    @RequestMapping(value = "/queryStatisticsList", method = RequestMethod.GET)
    public Map<String, Object> queryStatisticsList() {
        // 设置参数
        Map<String, Object> map = new HashMap<>();
        // 统计访问量
        map.put("countWebVV", SpringBootService.getUserService().selectList(new EntityWrapper<>()).size());
        // 统计浏览量
        map.put("countWebPV", SpringBootService.getSpringBootPropertiesLoad().getCountPV());
        // 统计用户数*
        map.put("countWebUV", SpringBootService.getUserService().selectList(new EntityWrapper<UserModel>().setSqlSelect("distinct ip")).size());
        // 统计留言数
        map.put("countMessage", SpringBootService.getMessageService().selectCount(new EntityWrapper<>()));
        // 统计友链数
        map.put("countLink", SpringBootService.getLinkService().selectCount(new EntityWrapper<>()));
        // 统计文章数
        map.put("countArticle", SpringBootService.getArticleService().selectCount(new EntityWrapper<>()));
        // 统计图片数
        map.put("countPhoto", SpringBootService.getPhotoService().selectCount(new EntityWrapper<>()));
        // 统计点赞数*
        map.put("countLike", SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleModel>().setSqlSelect("sum(likeAmount) as amount")).get("amount"));
        // 统计甩鞋数
        map.put("countLikeNo", SpringBootService.getArticleService().selectMap(new EntityWrapper<ArticleModel>().setSqlSelect("sum(likeNoAmount) as amount ")).get("amount"));

        return map;
    }

    //****************************************监控模块****************************************//

    /**
     * 功能描述: 监控新增
     *
     * @param: [monitorModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:42
     */
    @RequestMapping(value = "/addMonitor", method = RequestMethod.POST)
    public boolean addMonitor(MonitorModel monitorModel) {
        return SpringBootService.getMonitorService().insert(monitorModel);
    }

    /**
     * 功能描述: 监控更新
     *
     * @param: [monitorModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:45
     */
    @RequestMapping(value = "/updateMonitor", method = RequestMethod.PUT)
    public boolean updateMonitor(@RequestBody MonitorModel monitorModel) {
        return SpringBootService.getMonitorService().updateById(monitorModel);
    }

    /**
     * 功能描述: 监控删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 16:47
     */
    @RequestMapping(value = "/deleteMonitor/{id}", method = RequestMethod.DELETE)
    public boolean deleteMonitor(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getMonitorService().deleteById(id);
    }

    /**
     * 功能描述: 监控分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MonitorModel>
     * @auther: darker
     * @date: 2018/7/20 16:50
     */
    @RequestMapping(value = "/allMonitor", method = RequestMethod.GET)
    public List<MonitorModel> queryAllMonitor(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getMonitorService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}