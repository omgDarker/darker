package com.vip.darker.util;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.ColumnModel;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Darker
 * @Date: 2018/9/14 16:55
 * @Description: 网站相关工具类
 */
public class WebSiteUtil {

    /**
     * 功能描述: 获取网站右侧信息
     *
     * @param: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/9/4 18:00
     */
    public static void getWebOffsideInformation(ModelAndView modelAndView) {
        // 栏目列表
        modelAndView.addObject("columnList", SpringBootService.getColumnService().selectList(new EntityWrapper<>()));
        // 网站累计浏览量
        modelAndView.addObject("countPV", SpringBootService.getSpringBootPropertiesLoad().getCountPV());
        // 友情列表
        modelAndView.addObject("linkList", SpringBootService.getLinkService().selectList(new EntityWrapper<>()));
        // 图片列表
        modelAndView.addObject("photoList", SpringBootService.getPhotoService().selectList(new EntityWrapper<PhotoModel>().ne("columnId", "9")));
        // 文章列表<阅读排行>
        modelAndView.addObject("readAmountList", WebSiteUtil.setColumnNameList(SpringBootService.getArticleService().selectList(new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("readAmount")).last("LIMIT 5"))));
        // 文章列表<博主推荐>
        modelAndView.addObject("likeAmountList", WebSiteUtil.setColumnNameList(SpringBootService.getArticleService().selectList(new EntityWrapper<ArticleModel>().orderDesc(Collections.singletonList("likeAmount")).last("LIMIT 5"))));
    }

    /**
     * 功能描述: 设置分类名称在文章列表
     *
     * @auther: darker
     * @date: 2018/9/14 16:57
     */
    private static List<ArticleModel> setColumnNameList(List<ArticleModel> list) {

        for (ArticleModel model : list) {
            // 获取columnId
            String columnId = model.getColumnId();
            // 根据columnId获取columnName
            Map<String, Object> map = SpringBootService.getColumnService().selectMap(new EntityWrapper<ColumnModel>().where("id={0}", model.getColumnId()));
            if (map != null) {
                model.setColumnName(map.get("name") + "");
            } else {
                model.setColumnName("其他类型");
            }
        }
        return list;
    }

    /**
     * 功能描述: 移除字符串空格、回车
     *
     * @auther: darker
     * @date: 2018/9/14 16:57
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 功能描述: 根据IP获取国家名称
     *
     * @auther: darker
     * @date: 2018/9/14 16:57
     */
    public static String getCountryNameByIp(String ip) {

        if ("127.0.0.1".equals(ip) || "".equals(ip)) return "中国";

        try {
            // 创建 GeoLite2 数据库
            File database = ResourceUtils.getFile("classpath:db/GeoLite2-City.mmdb");
            // 读取数据库内容
            DatabaseReader reader = new DatabaseReader.Builder(database).build();


            InetAddress ipAddress = InetAddress.getByName(ip);
            // 获取查询结果
            CityResponse response = reader.city(ipAddress);
            // 获取国家信息
            Country country = response.getCountry();

            if (country != null) {
                return country.getNames().get("zh-CN");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}