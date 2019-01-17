package com.vip.darker.properties;

import com.vip.darker.annotation.BKDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: 流量属性值
 */
@Component(value = PropertiesStatDTO.BEAN_NAME)
@ConfigurationProperties(prefix = "statistics") //.yml文件属性值前缀
public class PropertiesStatDTO {

    public static final String BEAN_NAME = "propertiesStat";
    @BKDefinition(value = "记录浏览量VV")
    private int countPV;
    @BKDefinition(value = "记录访问量PV")
    private int countVV;
    @BKDefinition(value = "记录访问人数UV")
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

    public int addCountPV() {
        return countPV++;
    }

    public int addCountVV() {
        return countVV++;
    }

    public int addCountUV() {
        return countUV++;
    }
}