package com.vip.darker.controller.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.SessionUtil;
import com.vip.darker.util.WebSiteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 重定向controller
 */
@Controller
public class RedirectController {
    // 标识浏览量PV是否已初始化
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
    @RequestMapping(value = {"/", "/index", "/index/", "/index/home", "/home"})
    @SuppressWarnings(value = "unchecked")
    public String defaultIndex(HttpServletRequest request) {
        // 加锁防止并发
        synchronized (this) {
            // 1.网站浏览量PV初始化
            if (init) {
                // 查询数据库,重置浏览量PV
                Optional<Map<String, Object>> optional = Optional.ofNullable(SpringBootService.getStatisticsService().selectMap(new EntityWrapper<StatisticsModel>().where("classify={0}", "pv")));

                optional.ifPresent(opt -> SpringBootService.getSpringBootPropertiesLoad().setCountPV((int) opt.getOrDefault("amount", 8888)));

                init = false;
            }
            // 2.网站访问量VV
            List<UserModel> userList = (List<UserModel>) Optional.ofNullable(request.getServletContext().getAttribute("userList"))
                    .orElse(new ArrayList<>());
            // 获得用户sessionId
            String sessionId = request.getSession().getId();
            // 根据sessionId判断用户是否存在,若不存在则新增用户
            if (SessionUtil.getUserBySessionId(userList, sessionId) == null) {
                UserModel user = new UserModel();
                user.setName("陌生人");
                user.setEmail("stranger@qq.vip.com");
                user.setSessionId(sessionId);
                // 获取IP
                String ip = WebSiteUtil.getIpAddr(request);
                user.setIp(ip);
                user.setArea(WebSiteUtil.getCountryNameByIp(ip));
                user.setLoginTime(new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date()));
                userList.add(user);
                // 持久化到DB
                SpringBootService.getUserService().insert(user);
            }
            // 重置用户列表
            request.getServletContext().setAttribute("userList", userList);
            // 3.缓存操作,获取文章信息
            try {
                Object cacheObj = SpringBootService.getRedisService().get(Constant.REDIS_KEY_ARTICLE);
                // 判断缓存是否命中
                if (cacheObj == null) {
                    // 重新设置缓存
                    SpringBootService.getRedisService().set(Constant.REDIS_KEY_ARTICLE, SpringBootService.getArticleService().selectList(new EntityWrapper<>()));
                }
            } catch (Exception e) {
                logger.info("{}:redis服务启动异常!", "[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
            }
        }
        return "index/welcome";
    }
}