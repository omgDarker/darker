package com.vip.darker.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vip.darker.dao.VisitorDao;
import com.vip.darker.model.VisitorModel;
import com.vip.darker.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = VisitorServiceImpl.BEAN_NAME)
public class VisitorServiceImpl implements VisitorService {

    public static final String BEAN_NAME = "visitorService";

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public int addVisitor(VisitorModel visitorModel) {
        return visitorDao.insert(visitorModel);
    }

    @Override
    public PageInfo<VisitorModel> queryAllVisitor(int pageNum, int pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);

        List<VisitorModel> list = visitorDao.selectAllVisitor();

        PageInfo result = new PageInfo(list);

        return result;
    }
}
