package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.UserMapper;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 22:30
 * @Description: 用户service
 */
@Service(value = "userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean add(UserModel userModel) {
        return userMapper.add(userModel);
    }
}
