package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ImageDao;
import com.vip.darker.entity.ImageDO;
import com.vip.darker.service.ImageService;
import org.springframework.stereotype.Service;

@Service(value = ImageServiceImpl.BEAN_NAME)
public class ImageServiceImpl extends ServiceImpl<ImageDao, ImageDO> implements ImageService {
    public static final String BEAN_NAME = "imageService";
}
