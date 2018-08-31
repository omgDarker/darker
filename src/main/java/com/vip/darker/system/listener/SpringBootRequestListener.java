package com.vip.darker.system.listener;

import com.vip.darker.model.UserModel;
import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: ServletRequestListener监听器统计用户信息
 */
@WebListener
public class SpringBootRequestListener implements ServletRequestListener {
    // 在线用户列表
    private List<UserModel> list = new ArrayList<>();

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

        // 在servlectcontext域对象中,获取用户列表
        list = (List<UserModel>) servletRequestEvent.getServletRequest().getServletContext().getAttribute("userList");

        if (list == null) {
            list = new ArrayList<>();
        }
        // 获得用户sessionId
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();

        if (SessionUtil.getUserBySessionId(list, sessionId) == null) {
            UserModel user = new UserModel();
            user.setSessionId(sessionId);
            //获得ip地址
            user.setIp(request.getRemoteAddr());
            //获得登录地址
            user.setLoginTime(new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date()));
            list.add(user);
        }
        // 重置用户集合
        request.getServletContext().setAttribute("userList", list);
        logger.info("{}:当前用户数量:{}", "requestInitialized", list.size());
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
        // list是存储在域对象ServletContext中，用于记录用户的的日志信息
        list = (List<UserModel>) servletRequestEvent.getServletRequest().getServletContext().getAttribute("userList");
        // 获得用户sessionId
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();
        // 根据sessionid删除将要退出的用户
        SessionUtil.remove(list, sessionId);
        // 重置用户集合
        request.getServletContext().setAttribute("userList", list);
        logger.info("{}:当前用户数量:{}", "requestDestroyed", list.size());
    }
}
