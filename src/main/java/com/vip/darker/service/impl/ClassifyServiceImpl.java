package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ClassifyDao;
import com.vip.darker.entity.ClassifyDO;
import com.vip.darker.service.ClassifyService;
import org.springframework.stereotype.Service;

@Service(value = ClassifyServiceImpl.BEAN_NAME)
public class ClassifyServiceImpl extends ServiceImpl<ClassifyDao, ClassifyDO> implements ClassifyService {
    public static final String BEAN_NAME = "classifyService";
}
