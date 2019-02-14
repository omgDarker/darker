package com.vip.darker.system.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Configuration
@ConfigurationProperties(prefix = "pool")
public class AsyncTaskExecutorPool {
    /**
     * 核心线程数
     */
    @Value("${pool.core-pool-size}")
    private int corePoolSize;
    /**
     * 最大线程数
     */
    @Value("${pool.max-pool-size}")
    private int maxPoolSize;
    /**
     * 队列容量
     */
    @Value("${pool.queue-capacity}")
    private int queueCapacity;
    /**
     * 线程活跃时间(秒)
     */
    @Value("${pool.keep-alive-seconds}")
    private int keepAliveSeconds;

    private Logger logger = LoggerFactory.getLogger(AsyncTaskExecutorPool.class);

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();

        pool.setCorePoolSize(corePoolSize);

        pool.setMaxPoolSize(maxPoolSize);

        pool.setQueueCapacity(queueCapacity);

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