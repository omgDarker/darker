package com.vip.darker.system.listener;

import com.vip.darker.service.base.SpringBootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: request监听器 统计网站浏览量
 */
@WebListener
public class SpringBootRequestListener implements ServletRequestListener {

    private Logger logger = LoggerFactory.getLogger(SpringBootRequestListener.class);

    /**
     * 功能描述: request每次请求调用方法
     *
     * @param: [event]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    public void requestInitialized(ServletRequestEvent event) {
        // 当前PV值+1
        int countPV = SpringBootService.getPropertiesStat().addCountPV();
        logger.info("[当前网站浏览量的值]:{}", countPV);
    }

    /**
     * 功能描述: request每次销毁调用方法
     *
     * @param: [event]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
    }
}