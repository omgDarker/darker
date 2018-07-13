package com.vip.darker.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vip.darker.dao.VisitorDao;
import com.vip.darker.model.Visitor;
import com.vip.darker.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : P2M.WBA
 * @version : 2.9.6
 * @description :
 * @date : Create in 2018-07-13 14:06
 */
@Service(value = "visitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public int addVisitor(Visitor visitor) {
        return visitorDao.insertSelective(visitor);
    }

    @Override
    public PageInfo<Visitor> queryAllVisitor(int pageNum, int pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);

        List<Visitor> list = visitorDao.selectAllVisitor();

        PageInfo result = new PageInfo(list);

        return result;
    }
}
