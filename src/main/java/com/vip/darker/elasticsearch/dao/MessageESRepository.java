package com.vip.darker.elasticsearch.dao;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageESRepository extends ElasticsearchRepository<MessageDTO, Long> {
}