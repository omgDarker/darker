package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.PermissionMapper;
import com.vip.darker.model.PermissionModel;
import com.vip.darker.service.PermissionService;
import org.springframework.stereotype.Service;

@Service(value = PermissionServiceImpl.BEAN_NAME)
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionModel> implements PermissionService {
    public static final String BEAN_NAME = "permissionService";
}
