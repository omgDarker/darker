package com.vip.darker.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ResourceDao;
import com.vip.darker.entity.ResourceDO;
import com.vip.darker.service.ResourceService;
import org.springframework.stereotype.Service;

@Service(value = ResourceServiceImpl.BEAN_NAME)
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceDO> implements ResourceService {
    public static final String BEAN_NAME = "resourceService";
}
