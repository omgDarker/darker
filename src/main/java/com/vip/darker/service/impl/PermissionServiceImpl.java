package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.PermissionMapper;
import com.vip.darker.model.PermissionModel;
import com.vip.darker.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 23:00
 * @Description: 权限service
 */
@Service(value = "permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionModel> implements PermissionService {
}
