package com.vip.darker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 启动类注释
@MapperScan("com.vip.darker.dao")
public class DarkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DarkerApplication.class, args);
    }
}
