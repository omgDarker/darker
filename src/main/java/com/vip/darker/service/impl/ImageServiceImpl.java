package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ImageMapper;
import com.vip.darker.model.ImageModel;
import com.vip.darker.service.ImageService;
import org.springframework.stereotype.Service;

@Service(value = ImageServiceImpl.BEAN_NAME)
public class ImageServiceImpl extends ServiceImpl<ImageMapper, ImageModel> implements ImageService {
    public static final String BEAN_NAME = "imageService";
}
