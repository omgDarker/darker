package com.vip.darker.dao;

import com.vip.darker.model.Visitor;

import java.util.List;

public interface VisitorDao {

    int deleteByPrimaryKey(Integer userId);

    int insert(Visitor visitor);

    int insertSelective(Visitor visitor);

    Visitor selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Visitor visitor);

    int updateByPrimaryKey(Visitor visitor);

    List<Visitor> selectAllVisitor();
}
