package com.vip.darker.system.Interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.exception.LoginException;
import com.vip.darker.model.UserModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Darker
 * @description ：登录拦截器配置
 * @date : 2018/9/12 16:36
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 功能描述: 登录执行之前,验证用户是否存在
     *
     * @return: [boolean]
     * @auther: darker
     * @date: 2018/9/12 16:47
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Object user = SystemServiceLocator.getUserService().selectObj(new EntityWrapper<UserModel>().where("name={0}", name).and("password={0}", password));
        // 防止游客,恶意登录
        if (user != null && password.equals("darker")) {
            return true;
        }
        throw new LoginException("异常登录,请注意!");
    }
}
