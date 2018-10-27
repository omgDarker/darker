package com.vip.darker.system.pool.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: Darker
 * @Date: 2018/10/23 16:28
 * @Description: 线程池配置
 */
@ConfigurationProperties(prefix = "pool")
public class AsyncTaskExecutorPoolConfig {
    // 核心线程数
    @Value("${pool.core-pool-size}")
    private int corePoolSize;
    // 最大线程数
    @Value("${pool.max-pool-size}")
    private int maxPoolSize;
    // 队列容量
    @Value("${pool.queue-capacity}")
    private int queueCapacity;
    // 线程活跃时间(秒)
    @Value("${pool.keep-alive-seconds}")
    private int keepAliveSeconds;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }
}