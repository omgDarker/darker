package com.vip.darker.dao;

import com.vip.darker.model.PermissionModel;

public interface PermissionDao {

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionModel record);

    int insertSelective(PermissionModel record);

    PermissionModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionModel record);

    int updateByPrimaryKey(PermissionModel record);
}