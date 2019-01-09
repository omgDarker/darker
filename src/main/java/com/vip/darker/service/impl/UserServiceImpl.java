package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.UserDao;
import com.vip.darker.entity.UserDO;
import com.vip.darker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = UserServiceImpl.BEAN_NAME)
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    public static final String BEAN_NAME = "userService";

    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(UserDO userDO) {
        return userDao.add(userDO);
    }
}
