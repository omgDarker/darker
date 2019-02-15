package com.vip.darker.system.schedule;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.entity.StatisticsDO;
import com.vip.darker.entity.UserDO;
import com.vip.darker.service.base.SpringBootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 22:53
 * @Description: 定时任务
 */
@Component
public class ScheduleTask {

    private Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    /**
     * 每天24点执行一次
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setV() {
        // 查询网站流量统计数据
        List<StatisticsDO> flowList = SpringBootService.getStatisticsService().selectList(new EntityWrapper<>());
        List<StatisticsDO> resultlist = new ArrayList<>();
        for (StatisticsDO model : flowList) {
            StatisticsDO statisticsDO = new StatisticsDO();
            statisticsDO.setId(model.getId());
            switch (model.getClassify()) {
                case "pv":
                    statisticsDO.setAmount(SpringBootService.getPropertiesStat().getCountPV());
                    break;
                case "vv":
                    statisticsDO.setAmount(SpringBootService.getUserService().selectList(new EntityWrapper<>()).size());
                    break;
                case "uv":
                    statisticsDO.setAmount(SpringBootService.getUserService().selectList(new EntityWrapper<UserDO>().setSqlSelect("distinct ip")).size());
                    break;
                default:
                    logger.info("表operation_statistics存在脏数据,请仔细检查DB!");
                    break;
            }
            resultlist.add(statisticsDO);
        }
        SpringBootService.getStatisticsService().updateBatchById(resultlist);
        logger.info("setV()方法执行完成,流量数据已经持久化到DB!");
    }
}