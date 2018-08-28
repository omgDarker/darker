package com.vip.darker.system.schedule;

import com.vip.darker.model.StatisticsModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 22:53
 * @Description: 定时任务
 */
@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0 0 * * ? ") // 每天24点执行一次
    public void setPV() {
        // 获取当前浏览量值
        int countPv = SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV();
        // 持久化到数据库
        StatisticsModel statisticsModel = new StatisticsModel();
        statisticsModel.setId( 1 );
        statisticsModel.setAmount( countPv );
        SystemServiceLocator.getStatisticsService().updateById( statisticsModel );
    }
}
