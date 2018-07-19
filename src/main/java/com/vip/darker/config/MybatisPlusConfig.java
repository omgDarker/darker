package com.vip.darker.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {

    /**
     * 性能监控
     *
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {

        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // SQL执行性能分析,推荐开发环境使用,maxTime指sql最大执行时长
        performanceInterceptor.setMaxTime(1000);
        // SQL开启格式化
        performanceInterceptor.setFormat(true);

        return performanceInterceptor;
    }

    /**
     * 分页
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据库连接池注入
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(value = "spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder
                .create()
                .build();
    }
}
