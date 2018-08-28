package com.vip.darker.system.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 22:48
 * @Description: 定时任务线程池
 */
@Configuration //Config配置类。相当于spring3.0时期的XML配置文件
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 设置一个长度为10的定时任务线程池
        scheduledTaskRegistrar.setScheduler( Executors.newScheduledThreadPool( 10 ));
    }
}
