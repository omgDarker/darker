package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.PhotoMapper;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.service.PhotoService;
import org.springframework.stereotype.Service;

@Service(value = PhotoServiceImpl.BEAN_NAME)
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, PhotoModel> implements PhotoService {
    public static final String BEAN_NAME = "photoService";
}
