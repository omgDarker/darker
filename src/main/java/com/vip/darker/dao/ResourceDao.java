package com.vip.darker.dao;

import com.vip.darker.model.ResourceModel;

public interface ResourceDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ResourceModel record);

    int insertSelective(ResourceModel record);

    ResourceModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceModel record);

    int updateByPrimaryKey(ResourceModel record);
}