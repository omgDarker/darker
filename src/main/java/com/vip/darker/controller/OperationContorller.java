package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.MonitorModel;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 16:03
 * @Description: 监控统计Controller
 */
public class OperationContorller {

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
        return SystemServiceLocator.getStatisticsService().insert(statisticsModel);
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
        return SystemServiceLocator.getStatisticsService().deleteById(id);
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
        return SystemServiceLocator.getStatisticsService().updateById(statisticsModel);
    }

    /**
     * 功能描述: 统计分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.StatisticsModel>
     * @auther: darker
     * @date: 2018/7/20 16:41
     */
    public List<StatisticsModel> queryAllStatistics(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return SystemServiceLocator.getStatisticsService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

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
        return SystemServiceLocator.getMonitorService().insert(monitorModel);
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
        return SystemServiceLocator.getMonitorService().updateById(monitorModel);
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
        return SystemServiceLocator.getMonitorService().deleteById(id);
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
    public List<MonitorModel> queryAllMonitor(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return SystemServiceLocator.getMonitorService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
