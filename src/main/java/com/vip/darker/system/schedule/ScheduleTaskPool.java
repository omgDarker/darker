package com.vip.darker.system.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 22:48
 * @Description: 定时任务线程池
 */
@Configuration
public class ScheduleTaskPool implements SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(ScheduleTaskPool.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 设置线程池大小
        taskScheduler.setPoolSize(10);
        // 设置默认线程名称前缀
        taskScheduler.setThreadNamePrefix("ScheduleTask-");
        // 设置拒绝策略
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskScheduler.initialize();
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
    }
}