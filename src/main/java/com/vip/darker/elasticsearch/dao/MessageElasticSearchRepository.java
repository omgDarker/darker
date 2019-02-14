package com.vip.darker.elasticsearch.dao;

import com.vip.darker.elasticsearch.entity.MessageElaticsSearchDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageElasticSearchRepository extends ElasticsearchRepository<MessageElaticsSearchDTO, Long> {
}