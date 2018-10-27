package com.vip.darker.system.pool;

import com.vip.darker.system.pool.config.AsyncTaskExecutorPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: Darker
 * @Date: 2018/10/23 16:28
 * @Description: 线程池配置
 */
@Configuration // 声明一个配置类
@EnableAsync// 开启对异步任务的支持
public class AsyncTaskExecutorPool implements AsyncConfigurer {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskExecutorPool.class);

    private final AsyncTaskExecutorPoolConfig config;

    @Autowired
    public AsyncTaskExecutorPool(AsyncTaskExecutorPoolConfig config) {
        this.config = config;
    }

    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();

        pool.setCorePoolSize(config.getCorePoolSize());

        pool.setMaxPoolSize(config.getMaxPoolSize());

        pool.setQueueCapacity(config.getQueueCapacity());

        pool.setKeepAliveSeconds(config.getKeepAliveSeconds());
        // 设置默认线程名称前缀
        pool.setThreadNamePrefix("darker-");
        // 设置拒绝策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后,在关闭线程池
        pool.setWaitForTasksToCompleteOnShutdown(true);

        return pool;
    }

    /**
     * 异步任务中异常处理
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (arg0, arg1, arg2) -> {
            logger.error("==========================" + arg0.getMessage() + "==========================", arg0);
            logger.error("exception method:" + arg1.getName());
        };
    }
}