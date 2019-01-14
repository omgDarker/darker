package com.vip.darker.system.Interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.entity.UserDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.system.exception.LoginException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:登录拦截器
 * @auther: WBA
 * @date: 2019/1/14 15:46
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * @description:登录执行之前,验证用户是否存在
     * @auther: WBA
     * @date: 2018/12/11 17:04
     * @param: [request, response, o]
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Object user = SpringBootService.getUserService().selectObj(new EntityWrapper<UserDO>().where("name={0}", name).and("password={0}", password));
        // 防止游客,恶意登录
        if (user != null && password.equals("wangbingan")) {
            return true;
        }
        throw new LoginException("[异常登录,请注意!]");
    }
}
