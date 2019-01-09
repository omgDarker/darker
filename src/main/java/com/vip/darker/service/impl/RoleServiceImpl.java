package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.RoleDao;
import com.vip.darker.entity.RoleDO;
import com.vip.darker.service.RoleService;
import org.springframework.stereotype.Service;

@Service(value = RoleServiceImpl.BEAN_NAME)
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleDO> implements RoleService {
    public static final String BEAN_NAME = "roleService";
}
