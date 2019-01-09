package com.vip.darker.controller.home;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.ArticleDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.ConvertAttribute;
import com.vip.darker.util.SessionUtil;
import com.vip.darker.util.WebSiteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 博客首页控制器
 */
@Controller
public class HomeController {

    private static final String HOME = "home";

    /**
     * @description:博客轮播图
     * @auther: WBA
     * @date: 2018/12/11 16:40
     * @param: [request, response]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        // 重置在线人数
        SessionUtil.resetOnlineList(request, response);
        return HOME + "/welcome";
    }

    /**
     * @description:博客首页
     * @auther: WBA
     * @date: 2018/12/11 16:40
     * @param: [pageNum, pageSize]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @SuppressWarnings(value = "unchecked")
    public ModelAndView index(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView(HOME + "/home");
        // redis中取文章列表
        List<ArticleDO> list = Optional.ofNullable((List<ArticleDO>) SpringBootService.getRedisService().get(Constant.REDIS_KEY_ARTICLE))
                .map(opt -> opt.subList((pageNum - 1) * pageSize, pageNum * pageSize > opt.size() ? opt.size() : pageNum * pageSize))
                .orElse(SpringBootService.getArticleService().selectPage(new Page<>(pageNum, pageSize), new EntityWrapper<ArticleDO>().orderDesc(Collections.singletonList("updateTime"))).getRecords());

        list.forEach(model -> {
            // 处理文章摘要长度
            String summary = model.getSummary();
            if (StringUtils.isNotBlank(summary)) {
                if (StringUtils.isNotBlank(model.getImageName())) {
                    // 若存在图片
                    model.setSummary(summary.substring(0, summary.length() > 90 ? 90 : summary.length()));
                }
            }
            // 文章栏目信息
            String columnName = Optional.ofNullable(model.getColumnId())
                    .map(opt -> ConvertAttribute.getColumnMap().get(Integer.valueOf(opt)))
                    .orElse("其他类型");
            model.setColumnName(columnName);
        });
        // 文章总数
        int numSum = SpringBootService.getArticleService().selectCount(new EntityWrapper<>());
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 总页数
        modelAndView.addObject("pageNumSum", (numSum - 1) / pageSize + 1);
        // 总条数
        modelAndView.addObject("numSum", numSum);
        // 文章列表
        modelAndView.addObject("list", list);
        // 网站右侧信息列表
        WebSiteUtil.getWebOffsideInformation(modelAndView);

        return modelAndView;
    }

    /**
     * @description:关于我
     * @auther: WBA
     * @date: 2018/12/11 16:40
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = HOME + "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView(HOME + "/about");
        return modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
    }
}