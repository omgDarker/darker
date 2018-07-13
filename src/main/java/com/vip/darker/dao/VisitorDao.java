package com.vip.darker.dao;

import com.vip.darker.model.Visitor;

import java.util.List;

public interface VisitorDao {

    int insert(Visitor visitor);

    List<Visitor> selectAllVisitor();
}
