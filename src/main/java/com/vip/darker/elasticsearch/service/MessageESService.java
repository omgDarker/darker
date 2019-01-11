package com.vip.darker.elasticsearch.service;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageESService {

    /**
     * @description:保存message实体
     * @auther: WBA
     * @date: 2019/1/11 17:05
     * @param: [messageDTO]
     * @return: void
     */
    void save(MessageDTO messageDTO);

    /**
     * @description:基于username和content进行检索, 返回分页
     * @auther: WBA
     * @date: 2019/1/11 16:58
     * @param: [username, content, pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page<MessageDTO> search(String username, String content, Pageable pageable);

    /**
     * @description:基于content进行检索,返回分页
     * @auther: WBA
     * @date: 2019/1/11 16:59
     * @param: [content, pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page<MessageDTO> search(String content, Pageable pageable);

    /**
     * @description:返回所有数据集合
     * @auther: WBA
     * @date: 2019/1/11 17:00
     * @param: [pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page findAll(Pageable pageable);
}