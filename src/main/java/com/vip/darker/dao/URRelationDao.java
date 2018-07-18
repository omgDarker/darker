package com.vip.darker.dao;

import com.vip.darker.model.URRelation;

public interface URRelationDao {

    int deleteByPrimaryKey(Integer id);

    int insert(URRelation record);

    int insertSelective(URRelation record);

    URRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(URRelation record);

    int updateByPrimaryKey(URRelation record);
}