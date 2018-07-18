package com.vip.darker.dao;

import com.vip.darker.model.PhotoModel;

public interface PhotoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoModel record);

    int insertSelective(PhotoModel record);

    PhotoModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhotoModel record);

    int updateByPrimaryKey(PhotoModel record);
}