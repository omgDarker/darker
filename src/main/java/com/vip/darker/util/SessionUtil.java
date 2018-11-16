package com.vip.darker.util;

import com.vip.darker.model.UserModel;
import com.vip.darker.service.base.SpringBootService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 13:51
 * @Description: session操作类
 */
public class SessionUtil {

    /**
     * 根据sessionID查找用户
     *
     * @param list
     * @param sessionId
     * @return
     */
    public static UserModel getUserBySessionId(List<UserModel> list, String sessionId) {
        if (list != null && list.size() > 0) {
            for (UserModel user : list) {
                if (user.getSessionId().equals(sessionId)) {
                    return user;
                }
            }
        }
        return null;
    }

    /**
     * 根据sessionID删除用户
     *
     * @param list
     * @param sessionId
     */
    public static void remove(List<UserModel> list, String sessionId) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSessionId().equals(sessionId)) {
                    list.remove(list.get(i));
                }
            }
        }
    }

    /**
     * 重置在线用户列表
     *
     * @param request
     * @param response
     */
    @SuppressWarnings(value = "unchecked")
    public static void resetOnlineList(HttpServletRequest request, HttpServletResponse response) {
        // 网站访问量VV
        List<UserModel> onlineList = (List<UserModel>) request.getServletContext().getAttribute("onlineList");
        if (onlineList == null) {
            onlineList = new ArrayList<>();
        }
        // 获得用户sessionId
        String sessionId = request.getSession().getId();
        // 若游客不存在用户列表中
        if (SessionUtil.getUserBySessionId(onlineList, sessionId) == null) {
            UserModel user = new UserModel();
            user.setName("陌生人");
            user.setEmail("stranger@qq.vip.com");
            user.setSessionId(sessionId);
            // 获取IP
            String ip = WebSiteUtil.getIpAddr(request);
            user.setIp(ip);
            user.setArea(WebSiteUtil.getCountryNameByIp(ip));
            user.setLoginTime(new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date()));
            onlineList.add(user);
            // 持久化到DB
            SpringBootService.getUserService().insert(user);
        }
        // 重置用户列表
        request.getServletContext().setAttribute("onlineList", onlineList);
    }
}