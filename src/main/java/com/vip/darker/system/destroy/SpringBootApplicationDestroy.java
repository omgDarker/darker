package com.vip.darker.system.destroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: springboot销毁后, 调用方法
 * @Note: @PreDestroy
 */
@Component
public class SpringBootApplicationDestroy implements DisposableBean, ExitCodeGenerator {

    private Logger logger = LoggerFactory.getLogger(SpringBootApplicationDestroy.class);

    @Override
    public void destroy() {
        logger.info("server is closed!");
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
