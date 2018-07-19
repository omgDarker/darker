package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.RoleMapper;
import com.vip.darker.model.RoleModel;
import com.vip.darker.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 22:54
 * @Description: 角色service
 */
@Service(value = "roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {
}
