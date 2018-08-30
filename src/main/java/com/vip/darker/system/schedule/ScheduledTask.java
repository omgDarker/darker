package com.vip.darker.system.schedule;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.system.locator.SystemServiceLocator;
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
public class ScheduledTask {

    private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(cron = "0 0 0 * * ?") // 每天24点执行一次
    public void setV() {
        // 查询网站流量统计数据
        List<StatisticsModel> flowList = SystemServiceLocator.getStatisticsService().selectList(new EntityWrapper<>());
        List<StatisticsModel> resultlist = new ArrayList<>();
        for (StatisticsModel model : flowList) {
            StatisticsModel statisticsModel = new StatisticsModel();
            statisticsModel.setId(model.getId());
            switch (model.getClassify()) {
                case "pv":
                    statisticsModel.setAmount(SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV());
                    break;
                case "vv":
                    statisticsModel.setAmount(SystemServiceLocator.getSpringBootPropertiesLoad().getCountVV());
                    break;
                case "uv":
                    statisticsModel.setAmount(SystemServiceLocator.getSpringBootPropertiesLoad().getCountUV());
                    break;
                default:
                    logger.info("表operation_statistics存在脏数据,请仔细检查DB!");
                    break;
            }
            resultlist.add(statisticsModel);
        }
        SystemServiceLocator.getStatisticsService().updateBatchById(resultlist);
        logger.info("setV()方法执行完成,流量数据已经持久化到DB!");
    }
}
