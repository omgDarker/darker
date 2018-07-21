package com.vip.darker.service;

import com.baomidou.mybatisplus.service.IService;
import com.vip.darker.model.UserModel;

public interface UserService extends IService<UserModel> {

    boolean add(UserModel userModel);
}
