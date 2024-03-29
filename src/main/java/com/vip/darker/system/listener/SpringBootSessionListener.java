package com.vip.darker.system.listener;

import com.vip.darker.entity.UserDO;
import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: session监听器 统计网站在线人数
 */
@WebListener
public class SpringBootSessionListener implements HttpSessionListener {

    private AtomicInteger onLine = new AtomicInteger(0);

    private Logger logger = LoggerFactory.getLogger(SpringBootSessionListener.class);

    /**
     * @description:每当session建立,在线用户人数+1
     * @auther: WBA
     * @date: 2018/12/11 17:08
     * @param: [event]
     * @return: void
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        onLine.getAndIncrement();
        event.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionCreated", onLine);
    }

    /**
     * @description:每当session销毁,在线用户人数-1
     * @auther: WBA
     * @date: 2018/12/11 17:08
     * @param: [event]
     * @return: void
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sessionDestroyed(HttpSessionEvent event) {
        onLine.getAndDecrement();
        event.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionDestroyed", onLine);
        // 销毁退出用户
        List<UserDO> list = (List<UserDO>) event.getSession().getServletContext().getAttribute("onlineList");

        String sessionId = event.getSession().getId();

        Optional.ofNullable(SessionUtil.getUserBySessionId(list, sessionId))
                .map(list::remove);
        // 重置用户集合
        event.getSession().getServletContext().setAttribute("onlineList", list);
    }
}