package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.MessageMapper;
import com.vip.darker.model.MessageModel;
import com.vip.darker.service.MessageService;
import org.springframework.stereotype.Service;

@Service(value = "messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageModel> implements MessageService {
}
