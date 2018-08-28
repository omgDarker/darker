package com.vip.darker.system.destroy;

import com.vip.darker.model.StatisticsModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: springboot销毁后, 调用方法
 */
@Component
public class SpringBootApplicationDestroy {

    @PreDestroy
    public void destroy() {
        // <浏览量>持久化到数据库
        StatisticsModel statisticsModel = new StatisticsModel();
        statisticsModel.setId(1);
        statisticsModel.setAmount(SystemServiceLocator.getSpringBootPropertiesLoad().getCountPV());
        SystemServiceLocator.getStatisticsService().insertOrUpdate(statisticsModel);
    }
}
