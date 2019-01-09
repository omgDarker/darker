package com.vip.darker.service;

import com.baomidou.mybatisplus.service.IService;
import com.vip.darker.entity.UserDO;

public interface UserService extends IService<UserDO> {

    boolean add(UserDO userDO);
}
