package com.vip.darker.controller.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.system.thread.RunnableThreadWebVV;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 重置项controller
 */
@Controller
public class RedirectController {

    private boolean init = true;

    /**
     * 功能描述: 博客首页
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/", "/index", "/index/", "/index/home"})
    public String defaultIndex() {
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
