package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.URRelationDao;
import com.vip.darker.entity.URRelationDO;
import com.vip.darker.service.URRelationService;
import org.springframework.stereotype.Service;

@Service(value = URRelationServiceImpl.BEAN_NAME)
public class URRelationServiceImpl extends ServiceImpl<URRelationDao, URRelationDO> implements URRelationService {
    public static final String BEAN_NAME = "urRelationService";
}
