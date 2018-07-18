package com.vip.darker.dao;

import com.vip.darker.model.TrashModel;

public interface TrashDao {

    int deleteByPrimaryKey(Integer id);

    int insert(TrashModel record);

    int insertSelective(TrashModel record);

    TrashModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrashModel record);

    int updateByPrimaryKey(TrashModel record);
}