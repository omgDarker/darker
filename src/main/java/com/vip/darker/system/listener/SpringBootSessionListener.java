package com.vip.darker.system.listener;

import com.vip.darker.model.UserModel;
import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: HttpSessionListener监听器统计
 */
@WebListener
public class SpringBootSessionListener implements HttpSessionListener {

    private int onLine = 0;

    private Logger logger = LoggerFactory.getLogger(SpringBootSessionListener.class);

    /**
     * 功能描述: 每当一个session会话建立,在线用户人数+1
     *
     * @param: [httpSessionEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onLine++;
        // 在线用户的数量存储到域对象ServletContext的number中
        httpSessionEvent.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionCreated", onLine);
    }

    /**
     * 功能描述: 每当一个session会话销毁,在线用户人数-1
     *
     * @param: [httpSessionEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onLine--;
        // 在线用户的数量存储到域对象ServletContext的number中
        httpSessionEvent.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionDestroyed", onLine);
        // 获取用户集合
        List<UserModel> list = (List<UserModel>) httpSessionEvent.getSession().getServletContext().getAttribute("userList");
        // 获取销毁用户sessionId
        String sessionId = httpSessionEvent.getSession().getId();
        // 如果当前用户在userList中,在session销毁时,将当前用户移出userList
        if (SessionUtil.getUserBySessionId(list, sessionId) != null) {
            list.remove(SessionUtil.getUserBySessionId(list, sessionId));
        }
        // 重置用户集合
        httpSessionEvent.getSession().getServletContext().setAttribute("userList", list);
    }
}
