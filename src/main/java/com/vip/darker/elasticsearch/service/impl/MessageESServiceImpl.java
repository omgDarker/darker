package com.vip.darker.elasticsearch.service.impl;

import com.vip.darker.elasticsearch.dao.MessageESRepository;
import com.vip.darker.elasticsearch.entity.MessageDTO;
import com.vip.darker.elasticsearch.service.MessageESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageESServiceImpl implements MessageESService {

    private final MessageESRepository messageESRepository;

    @Autowired
    public MessageESServiceImpl(MessageESRepository messageESRepository) {
        this.messageESRepository = messageESRepository;
    }

    @Override
    public void save(MessageDTO messageDTO) {
        messageESRepository.save(messageDTO);
    }

    @Override
    public Page<MessageDTO> search(String username, String content, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MessageDTO> search(String content, Pageable pageable) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return messageESRepository.findAll(pageable);
    }
}