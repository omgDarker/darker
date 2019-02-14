package com.vip.darker.elasticsearch.service;

import com.vip.darker.elasticsearch.entity.MessageElaticsSearchDTO;
import com.vip.darker.elasticsearch.entity.QueryParamDTO;
import com.vip.darker.vo.ResultVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageESService {

    /**
     * @description:索引新增
     * @auther: WBA
     * @date: 2019/1/15 15:55
     * @param: [messageDTO]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultVO save(MessageElaticsSearchDTO messageElaticsSearchDTO);

    /**
     * @description:索引批量新增
     * @auther: WBA
     * @date: 2019/1/15 15:42
     * @param: [messageDTOList]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultVO saveBatch(List<MessageElaticsSearchDTO> messageElaticsSearchDTOList);

    /**
     * @description:索引删除
     * @auther: WBA
     * @date: 2019/1/14 16:11
     * @param: [id]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultVO delete(Long id);

    /**
     * @description:索引批量删除
     * @auther: WBA
     * @date: 2019/1/15 15:46
     * @param: [ids]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultVO deleteBatch(Long[] ids);

    /**
     * @description:基于key,val键值对进行检索,返回结果集
     * @auther: WBA
     * @date: 2019/1/15 18:25
     * @param: [pageable, queryParamDTO]
     * @return: com.vip.darker.entity.ResultDTO
     */
    ResultVO search(Pageable pageable, QueryParamDTO queryParamDTO);

    /**
     * @description:返回所有数据集合
     * @auther: WBA
     * @date: 2019/1/11 17:00
     * @param: [pageable]
     * @return: org.springframework.data.domain.Page<com.vip.darker.elasticsearch.entity.MessageDTO>
     */
    List<MessageElaticsSearchDTO> search(Pageable pageable);
}