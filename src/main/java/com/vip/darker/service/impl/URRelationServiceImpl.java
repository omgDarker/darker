package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.URRelationMapper;
import com.vip.darker.model.URRelation;
import com.vip.darker.service.URRelationService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/7/21 10:10
 * @Description:
 */
@Service(value = "urRelationService")
public class URRelationServiceImpl extends ServiceImpl<URRelationMapper, URRelation> implements URRelationService {
}
