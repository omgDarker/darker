package com.vip.darker.dao;

import com.vip.darker.model.MessageModel;

public interface MessageDao {

    int deleteByPrimaryKey(Integer id);

    int insert(MessageModel record);

    int insertSelective(MessageModel record);

    MessageModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageModel record);

    int updateByPrimaryKey(MessageModel record);
}