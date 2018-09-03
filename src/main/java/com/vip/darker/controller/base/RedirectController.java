package com.vip.darker.controller.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.model.UserModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 重置项controller
 */
@Controller
public class RedirectController {

    private boolean init = true;

    private Logger logger = LoggerFactory.getLogger(RedirectController.class);

    /**
     * 功能描述: 博客首页
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/", "/index", "/index/", "/index/home"})
    @SuppressWarnings(value = "unchecked")
    public String defaultIndex(HttpServletRequest request) {
        // 加锁防止并发
        synchronized (this) {
            // 网站浏览量数值初始化
            if (init) {
                // 查询数据库,若值存在,则重置浏览量数值
                Map<String, Object> map = SystemServiceLocator.getStatisticsService().selectMap(new EntityWrapper<StatisticsModel>().where("classify={0}", "pv"));
                if (map != null) {
                    if (map.containsKey("amount")) {
                        SystemServiceLocator.getSpringBootPropertiesLoad().setCountPV((int) map.get("amount"));
                    }
                }
                init = false;
            }
            // 网站访问人数
            // 获取用户列表
            List<UserModel> list = (List<UserModel>) request.getServletContext().getAttribute("userList");
            if (list == null) {
                list = new ArrayList<>();
            }
            // 获得用户sessionId
            String sessionId = request.getSession().getId();
            // 判断是否存在此游客
            if (SessionUtil.getUserBySessionId(list, sessionId) == null) {
                UserModel user = new UserModel();
                user.setSessionId(sessionId);
                // 获得ip地址
                user.setIp(request.getRemoteAddr());
                // 获得登录地址
                user.setLoginTime(new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date()));
                list.add(user);
                // 持久化到DB
                SystemServiceLocator.getUserService().insert(user);
            }
            // 重置用户集合
            request.getServletContext().setAttribute("userList", list);
        }
        return "redirect:index/home";
    }

    /**
     * 功能描述: 关于我
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/about", "/about/"})
    public String defaultAbout() {
        return "redirect:index/about";
    }

    /**
     * 功能描述: 相册
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/photo", "/photo/"})
    public String defaultPhoto() {
        return "redirect:index/photo";
    }

    /**
     * 功能描述: 留言板
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/message", "/message/"})
    public String defaultMessage() {
        return "redirect:index/message";
    }

}
