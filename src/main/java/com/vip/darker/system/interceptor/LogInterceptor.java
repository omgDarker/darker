package com.vip.darker.system.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:日志拦截器
 * @auther: WBA
 * @date: 2019/1/14 15:46
 */
public class LogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    /**
     * @description:方法执行之前
     * @auther: WBA
     * @date: 2018/12/11 17:05
     * @param: [request, response, o]
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        logger.info("请求路径：{}", request.getRequestURL());
        return true;
    }

    /**
     * @description:方法执行之后,页面渲染前
     * @auther: WBA
     * @date: 2018/12/11 17:05
     * @param: [request, response, o, modelAndView]
     * @return: void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {
    }

    /**
     * @description:整个请求结束后,页面也渲染完毕,一般是资源清理操作
     * @auther: WBA
     * @date: 2018/12/11 17:05
     * @param: [request, response, o, e]
     * @return: void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }
}
