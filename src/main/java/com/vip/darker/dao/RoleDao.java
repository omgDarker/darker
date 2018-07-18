package com.vip.darker.dao;

import com.vip.darker.model.RoleModel;

public interface RoleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(RoleModel record);

    int insertSelective(RoleModel record);

    RoleModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleModel record);

    int updateByPrimaryKey(RoleModel record);
}