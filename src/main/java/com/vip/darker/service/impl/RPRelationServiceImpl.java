package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.RPRelationMapper;
import com.vip.darker.model.RPRelation;
import com.vip.darker.service.RPRelationService;
import org.springframework.stereotype.Service;

@Service(value = "rpRelationService")
public class RPRelationServiceImpl extends ServiceImpl<RPRelationMapper, RPRelation> implements RPRelationService {
}
