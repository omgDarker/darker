package com.vip.darker.system.destroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: springboot销毁后, 调用方法
 */
@Component
public class SpringBootApplicationDestroy {

    private Logger logger = LoggerFactory.getLogger(SpringBootApplicationDestroy.class);

    @PreDestroy
    public void destroy() {
        logger.info("server is closed!");
    }
}
