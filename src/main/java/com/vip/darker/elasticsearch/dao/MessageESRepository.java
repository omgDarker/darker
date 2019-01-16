package com.vip.darker.elasticsearch.dao;

import com.vip.darker.elasticsearch.entity.MessageESDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageESRepository extends ElasticsearchRepository<MessageESDTO, Long> {
}