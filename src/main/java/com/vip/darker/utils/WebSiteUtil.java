package com.vip.darker.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
import com.vip.darker.convert.ConvertAttribute;
import com.vip.darker.entity.ArticleDO;
import com.vip.darker.entity.ColumnDO;
import com.vip.darker.entity.ImageDO;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
        // 网站累计浏览量
        modelAndView.addObject("countPV", SpringBootService.getPropertiesStat().getCountPV());
        // 友情列表
        modelAndView.addObject("linkList", SpringBootService.getLinkService().selectList(new EntityWrapper<>()));
        // 图片列表
        modelAndView.addObject("imageList", SpringBootService.getImageService().selectList(new EntityWrapper<ImageDO>().ne("columnId", "9")));
        // 文章列表<阅读排行>
        modelAndView.addObject("readAmountList", WebSiteUtil.setColumnNameList(SpringBootService.getArticleService().selectList(new EntityWrapper<ArticleDO>().orderDesc(Collections.singletonList("readAmount")).last("LIMIT 5"))));
        // 文章列表<博主推荐>
        modelAndView.addObject("likeAmountList", WebSiteUtil.setColumnNameList(SpringBootService.getArticleService().selectList(new EntityWrapper<ArticleDO>().orderDesc(Collections.singletonList("likeAmount")).last("LIMIT 5"))));
    }

    /**
     * 功能描述: 设置分类名称在文章列表
     *
     * @auther: darker
     * @date: 2018/9/14 16:57
     */
    private static List<ArticleDO> setColumnNameList(List<ArticleDO> list) {

        for (ArticleDO model : list) {
            // 根据columnId获取columnName
            Map<String, Object> map = SpringBootService.getColumnService().selectMap(new EntityWrapper<ColumnDO>().where("id={0}", model.getColumnId()));
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
     * 功能描述: 获取当前网络IP
     *
     * @auther: darker
     * @date: 2018/10/31 18:11
     */
    static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet != null ? inet.getHostAddress() : null;
            }
        }
        // 对于通过多个代理的情况,第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 功能描述: 根据IP获取国家名称
     *
     * @auther: darker
     * @date: 2018/9/14 16:57
     */
    public static String getCountryNameByIp(String ip) {

        if ("127.0.0.1".equals(ip) || "192.168.1.197".equals(ip) || "".equals(ip)) return "中国";

        try {
            // 创建GeoLite2数据库
            File database = ResourceUtils.getFile("classpath:db/GeoLite2-City.mmdb");
            // 读取数据库内容,获取流
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            // 根据IP获取地址
            InetAddress ipAddress = InetAddress.getByName(ip);
            // 根据地址对照数据库内容流获取相应信息
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