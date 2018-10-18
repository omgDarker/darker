package com.vip.darker.runner;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.net.InetAddress;

/**
 * @Auther: Darker
 * @Date: 2018/10/18 17:58
 * @Description: 获取城市信息单元测试
 */
public class GeoLiteRunner {

    /**
     * 根据IP获取城市信息
     *
     * @throws Exception
     */
    @Test
    public void getCityByIp() throws Exception {
        // 创建 GeoLite2 数据库
        File database = ResourceUtils.getFile("classpath:db/GeoLite2-City.mmdb");

        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        InetAddress ipAddress = InetAddress.getByName("13.250.33.150");

        // 获取查询结果
        CityResponse response = reader.city(ipAddress);

        // 获取国家信息
        Country country = response.getCountry();
        System.out.println("国家简写：" + country.getIsoCode());               // 'CN'
        System.out.println("国家英文：" + country.getName());                  // 'China'
        System.out.println("国家中文：" + country.getNames().get("zh-CN"));    // '中国'

        // 获取省份
        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println("省份简写：" + subdivision.getIsoCode());// '45'
        System.out.println("省份英文：" + subdivision.getName());   // 'Guangxi Zhuangzu Zizhiqu'
        System.out.println("省份中文：" + subdivision.getNames().get("zh-CN")); // '广西壮族自治区'

        // 获取城市
        City city = response.getCity();
        System.out.println(city.getName()); // 'Nanning'
        Postal postal = response.getPostal();
        System.out.println(postal.getCode()); // 'null'
        System.out.println(city.getNames().get("zh-CN")); // '南宁'
        Location location = response.getLocation();
        System.out.println("纬度：" + location.getLatitude());  // 22.8167
        System.out.println("经度：" + location.getLongitude()); // 108.3167
    }
}