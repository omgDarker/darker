package com.vip.darker.system.load;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: springboot初始化加载YML配置文件值(VV, PV, UV)
 */
@Component(value = SpringBootPropertiesLoad.BEAN_NAME)
@ConfigurationProperties(prefix = "statistics") //.yml文件属性值前缀
public class SpringBootPropertiesLoad {

    public static final String BEAN_NAME = "springBootPropertiesLoad";
    // 记录浏览量
    private int countPV;
    // 记录访问量
    private int countVV;
    // 记录访问人数
    private int countUV;

    public int getCountPV() {
        return countPV;
    }

    public void setCountPV(int countPV) {
        this.countPV = countPV;
    }

    public int getCountVV() {
        return countVV;
    }

    public void setCountVV(int countVV) {
        this.countVV = countVV;
    }

    public int getCountUV() {
        return countUV;
    }

    public void setCountUV(int countUV) {
        this.countUV = countUV;
    }
}
