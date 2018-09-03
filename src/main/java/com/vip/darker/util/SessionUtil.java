package com.vip.darker.util;

import com.vip.darker.model.UserModel;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 13:51
 * @Description: sessionId操作类
 */
public class SessionUtil {

    /*
     * 根据sessionID查找用户
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

    /*
     * 根据sessionID删除用户
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
}
