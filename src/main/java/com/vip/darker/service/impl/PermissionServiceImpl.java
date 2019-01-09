package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.PermissionDao;
import com.vip.darker.entity.PermissionDO;
import com.vip.darker.service.PermissionService;
import org.springframework.stereotype.Service;

@Service(value = PermissionServiceImpl.BEAN_NAME)
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, PermissionDO> implements PermissionService {
    public static final String BEAN_NAME = "permissionService";
}
