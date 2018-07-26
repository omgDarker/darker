package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.RoleMapper;
import com.vip.darker.model.RoleModel;
import com.vip.darker.service.RoleService;
import org.springframework.stereotype.Service;

@Service(value = RoleServiceImpl.BEAN_NAME)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {
    public static final String BEAN_NAME = "roleService";
}
