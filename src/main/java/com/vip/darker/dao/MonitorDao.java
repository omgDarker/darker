package com.vip.darker.dao;

import com.vip.darker.model.MonitorModel;

public interface MonitorDao {

    int deleteByPrimaryKey(Integer id);

    int insert(MonitorModel record);

    int insertSelective(MonitorModel record);

    MonitorModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorModel record);

    int updateByPrimaryKey(MonitorModel record);
}