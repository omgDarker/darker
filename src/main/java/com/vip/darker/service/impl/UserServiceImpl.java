package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.UserMapper;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = UserServiceImpl.BEAN_NAME)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    public static final String BEAN_NAME = "userService";

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean add(UserModel userModel) {
        return userMapper.add(userModel);
    }
}
