package com.vip.darker.system.pool;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: Darker
 * @Date: 2018/10/23 16:28
 * @Description: 线程池配置
 */
@Configuration // 声明一个配置类
@ConfigurationProperties(prefix = "pool")
public class SpringBootPoolConfig {

    @Value("${pool.core-pool-size}")
    private int corePoolSize;

    @Value("${pool.max-pool-size}")
    private int maxPoolSize;

    @Value("${pool.queue-capacity}")
    private int queueCapacity;

    @Value("${pool.keep-alive-seconds}")
    private int keepAliveSeconds;

    @Bean
    public ThreadPoolTaskExecutor poolExecutor() {

        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        pool.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        pool.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        pool.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间(秒)
        pool.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称前缀
        pool.setThreadNamePrefix("darker-");
        // 设置拒绝策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后,在关闭线程池
        pool.setWaitForTasksToCompleteOnShutdown(true);

        return pool;
    }
}