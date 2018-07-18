package com.vip.darker.dao;

import com.vip.darker.model.ArticleModel;

public interface ArticleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleModel record);

    int insertSelective(ArticleModel record);

    ArticleModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleModel record);

    int updateByPrimaryKeyWithBLOBs(ArticleModel record);

    int updateByPrimaryKey(ArticleModel record);
}