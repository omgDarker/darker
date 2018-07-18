package com.vip.darker.dao;

import com.vip.darker.model.VisitorModel;

import java.util.List;

public interface VisitorDao {

    int insert(VisitorModel visitorModel);

    List<VisitorModel> selectAllVisitor();
}
