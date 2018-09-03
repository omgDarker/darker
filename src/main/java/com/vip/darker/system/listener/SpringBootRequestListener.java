package com.vip.darker.system.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: ServletRequestListener监听器统计用户信息
 */
@WebListener
public class SpringBootRequestListener implements ServletRequestListener {

    private Logger logger = LoggerFactory.getLogger(SpringBootRequestListener.class);

    /**
     * 功能描述: 每当一个request建立,将当前用户放入集合
     *
     * @param: [servletRequestEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @SuppressWarnings(value = "unchecked")
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }

    /**
     * 功能描述: 每当一个request销毁,将当前用户移出集合
     *
     * @param: [servletRequestEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @SuppressWarnings(value = "unchecked")
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }
}
