package com.vip.darker.dao;

import com.vip.darker.model.RPRelation;

public interface RPRelationDao {

    int deleteByPrimaryKey(Integer id);

    int insert(RPRelation record);

    int insertSelective(RPRelation record);

    RPRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RPRelation record);

    int updateByPrimaryKey(RPRelation record);
}