package com.vip.darker.dao;

import com.vip.darker.model.StatisticsModel;

public interface StatisticsDao {

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticsModel record);

    int insertSelective(StatisticsModel record);

    StatisticsModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatisticsModel record);

    int updateByPrimaryKey(StatisticsModel record);
}