package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.TrashDao;
import com.vip.darker.entity.TrashDO;
import com.vip.darker.service.TrashService;
import org.springframework.stereotype.Service;

@Service(value = TrashServiceImpl.BEAN_NAME)
public class TrashServiceImpl extends ServiceImpl<TrashDao, TrashDO> implements TrashService {
    public static final String BEAN_NAME = "trashService";
}
