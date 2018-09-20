package com.vip.darker.system.redis;

import com.vip.darker.DarkerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Auther: Darker
 * @Date: 2018/9/20 11:23
 * @Description: redis单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DarkerApplication.class)
@WebAppConfiguration
public class RedisRunner {

    @Autowired
    private RedisService redisService;


    @Test
    public void setValue() {
        redisService.set("darker2", "wangbingan");
    }
}
