package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.StatisticsMapper;
import com.vip.darker.model.StatisticsModel;
import org.springframework.stereotype.Service;

@Service(value = StatisticsServiceImpl.BEAN_NAME)
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, StatisticsModel> {
    public static final String BEAN_NAME = "statisticsService";
}
