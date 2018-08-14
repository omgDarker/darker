package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ColumnMapper;
import com.vip.darker.model.ColumnModel;
import com.vip.darker.service.ColumnService;
import org.springframework.stereotype.Service;

@Service(value = ColumnServiceImpl.BEAN_NAME)
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, ColumnModel> implements ColumnService {
    public static final String BEAN_NAME = "columnService";
}
