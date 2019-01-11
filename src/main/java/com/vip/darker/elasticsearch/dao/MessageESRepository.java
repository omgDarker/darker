package com.vip.darker.elasticsearch.dao;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MessageESRepository extends ElasticsearchRepository<MessageDTO, Long> {
}