package com.vip.darker.service;

import com.github.pagehelper.PageInfo;
import com.vip.darker.model.Visitor;

/**
 * @author : P2M.WBA
 * @version : 2.9.6
 * @description :
 * @date : Create in 2018-07-13 14:04
 */
public interface VisitorService {

    int addVisitor(Visitor visitor);

    PageInfo<Visitor> queryAllVisitor(int pageNum, int pageSize);
}
