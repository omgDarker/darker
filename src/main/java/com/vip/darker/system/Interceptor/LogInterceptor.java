package com.vip.darker.system.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Darker
 * @description ：日志拦截器配置
 * @date : 2018/9/16 13:24
 */
public class LogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    /**
     * 功能描述: 方法执行之前
     *
     * @return: [boolean]
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        logger.info("请求路径：{}", request.getRequestURL());
        return true;
    }

    /**
     * 功能描述: 方法执行之后,页面渲染前
     *
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {
    }

    /**
     * 功能描述: 整个请求结束后,页面也渲染完毕,一般是资源清理操作
     *
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }
}
