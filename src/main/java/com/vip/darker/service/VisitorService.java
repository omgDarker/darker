package com.vip.darker.service;

import com.github.pagehelper.PageInfo;
import com.vip.darker.model.VisitorModel;

public interface VisitorService {

    int addVisitor(VisitorModel visitorModel);

    PageInfo<VisitorModel> queryAllVisitor(int pageNum, int pageSize);
}
