package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.MessageDao;
import com.vip.darker.entity.MessageDO;
import com.vip.darker.service.MessageService;
import org.springframework.stereotype.Service;

@Service(value = MessageServiceImpl.BEAN_NAME)
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageDO> implements MessageService {
    public static final String BEAN_NAME = "messageService";
}
