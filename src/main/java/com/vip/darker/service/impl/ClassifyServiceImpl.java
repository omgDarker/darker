package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ClassifyMapper;
import com.vip.darker.model.ClassifyModel;
import com.vip.darker.service.ClassifyService;
import org.springframework.stereotype.Service;

@Service(value = ClassifyServiceImpl.BEAN_NAME)
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, ClassifyModel> implements ClassifyService {
    public static final String BEAN_NAME = "classifyService";
}
