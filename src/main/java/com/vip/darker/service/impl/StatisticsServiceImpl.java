package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.StatisticsDao;
import com.vip.darker.entity.StatisticsDO;
import com.vip.darker.service.StatisticsService;
import org.springframework.stereotype.Service;

@Service(value = StatisticsServiceImpl.BEAN_NAME)
public class StatisticsServiceImpl extends ServiceImpl<StatisticsDao, StatisticsDO> implements StatisticsService {
    public static final String BEAN_NAME = "statisticsService";
}
