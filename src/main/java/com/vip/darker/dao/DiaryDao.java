package com.vip.darker.dao;

import com.vip.darker.model.DiaryModel;

public interface DiaryDao {

    int deleteByPrimaryKey(Integer id);

    int insert(DiaryModel record);

    int insertSelective(DiaryModel record);

    DiaryModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiaryModel record);

    int updateByPrimaryKeyWithBLOBs(DiaryModel record);

    int updateByPrimaryKey(DiaryModel record);
}