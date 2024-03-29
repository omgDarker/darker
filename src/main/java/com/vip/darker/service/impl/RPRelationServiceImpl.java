package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.RPRelationDao;
import com.vip.darker.entity.RelationRpDO;
import com.vip.darker.service.RPRelationService;
import org.springframework.stereotype.Service;

@Service(value = RPRelationServiceImpl.BEAN_NAME)
public class RPRelationServiceImpl extends ServiceImpl<RPRelationDao, RelationRpDO> implements RPRelationService {
    public static final String BEAN_NAME = "rpRelationService";
}
