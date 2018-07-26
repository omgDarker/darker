package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.MonitorMapper;
import com.vip.darker.model.MonitorModel;
import com.vip.darker.service.MonitorService;
import org.springframework.stereotype.Service;

@Service(value = MonitorServiceImpl.BEAN_NAME)
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, MonitorModel> implements MonitorService {
    public static final String BEAN_NAME = "monitorService";
}
