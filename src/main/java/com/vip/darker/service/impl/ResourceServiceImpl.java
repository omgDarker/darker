package com.vip.darker.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ResourceMapper;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.ResourceService;
import org.springframework.stereotype.Service;

@Service(value = "resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper,ResourceModel> implements ResourceService {

}
