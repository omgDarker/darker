package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.LinkDao;
import com.vip.darker.entity.LinkDO;
import com.vip.darker.service.LinkService;
import org.springframework.stereotype.Service;

@Service(value = LinkServiceImpl.BEAN_NAME)
public class LinkServiceImpl extends ServiceImpl<LinkDao, LinkDO> implements LinkService {
    public static final String BEAN_NAME = "linkService";
}
