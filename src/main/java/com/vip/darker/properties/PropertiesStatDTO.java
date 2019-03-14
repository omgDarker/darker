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
@ConfigurationProperties(prefix = "statistics")
public class PropertiesStatDTO {

    public static final String BEAN_NAME = "propertiesStat";
    @BKDefinition(value = "记录浏览量VV")
    private Integer countPV;
    @BKDefinition(value = "记录访问量PV")
    private Integer countVV;
    @BKDefinition(value = "记录访问人数UV")
    private Integer countUV;

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

    @Override
    public String toString() {
        return "PropertiesStatDTO{" +
                "countPV=" + countPV +
                ", countVV=" + countVV +
                ", countUV=" + countUV +
                '}';
    }
}