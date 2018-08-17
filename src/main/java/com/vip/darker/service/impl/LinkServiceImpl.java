package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.LinkMapper;
import com.vip.darker.model.LinkModel;
import com.vip.darker.service.LinkService;
import org.springframework.stereotype.Service;

@Service(value = LinkServiceImpl.BEAN_NAME)
public class LinkServiceImpl extends ServiceImpl<LinkMapper, LinkModel> implements LinkService {
    public static final String BEAN_NAME = "linkService";
}
