package com.vip.darker.elasticsearch.service;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import com.vip.darker.entity.ResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

public interface MessageESService {

    /**
     * @description:索引新增
     * @auther: WBA
     * @date: 2019/1/15 15:55
     * @param: [messageDTO]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultDTO save(MessageDTO messageDTO);

    /**
     * @description:索引批量新增
     * @auther: WBA
     * @date: 2019/1/15 15:42
     * @param: [messageDTOList]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultDTO saveBatch(List<MessageDTO> messageDTOList);

    /**
     * @description:索引删除
     * @auther: WBA
     * @date: 2019/1/14 16:11
     * @param: [id]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultDTO delete(Long id);

    /**
     * @description:索引批量删除
     * @auther: WBA
     * @date: 2019/1/15 15:46
     * @param: [ids]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultDTO deleteBatch(Long[] ids);

    /**
     * @description:基于key,val键值对进行检索,返回结果集
     * @auther: WBA
     * @date: 2019/1/15 18:25
     * @param: [pageable, key, val]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultDTO search(Pageable pageable, String key, String val);

    /**
     * @description:基于关键词进行检索,返回分页
     * @auther: WBA
     * @date: 2019/1/11 16:58
     * @param: [username, content, pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page<MessageDTO> search(Pageable pageable, String... key);

    /**
     * @description:基于查询条件进行检索,返回分页
     * @auther: WBA
     * @date: 2019/1/14 11:18
     * @param: [searchQuery]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page<MessageDTO> search(SearchQuery searchQuery);

    /**
     * @description:返回所有数据集合
     * @auther: WBA
     * @date: 2019/1/11 17:00
     * @param: [pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    Page<MessageDTO> search(Pageable pageable);
}