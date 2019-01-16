package com.vip.darker.elasticsearch.service.impl;

import com.vip.darker.annotation.BKDefinition;
import com.vip.darker.elasticsearch.dao.MessageESRepository;
import com.vip.darker.elasticsearch.entity.MessageESDTO;
import com.vip.darker.elasticsearch.service.MessageESService;
import com.vip.darker.entity.ResultDTO;
import com.vip.darker.util.Constant;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = MessageESServiceImpl.BEAN_NAME)
public class MessageESServiceImpl implements MessageESService {

    public static final String BEAN_NAME = "messageESService";

    private final MessageESRepository messageESRepository;
    @BKDefinition(value = "接收结果集")
    private ResultDTO resultDTO = new ResultDTO();

    @Autowired
    public MessageESServiceImpl(MessageESRepository messageESRepository) {
        this.messageESRepository = messageESRepository;
    }

    @Override
    public ResultDTO save(MessageESDTO messageESDTO) {
        try {
            messageESRepository.save(messageESDTO);
            resultDTO.setCode(200);
            resultDTO.setMsg(Constant.SUCCESS_INSERT);
        } catch (Exception e) {
            resultDTO.setCode(500);
            resultDTO.setMsg(Constant.FAIL_INSERT);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO saveBatch(List<MessageESDTO> messageESDTOList) {
        try {
            messageESRepository.saveAll(messageESDTOList);
            resultDTO.setCode(200);
            resultDTO.setMsg(Constant.SUCCESS_INSERT);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setCode(500);
            resultDTO.setMsg(Constant.FAIL_INSERT);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO delete(Long id) {
        try {
            messageESRepository.deleteById(id);
            resultDTO.setCode(200);
            resultDTO.setMsg(Constant.SUCCESS_DELETE);
        } catch (Exception e) {
            resultDTO.setCode(500);
            resultDTO.setMsg(Constant.FAIL_DELETE);
        }
        return resultDTO;

    }

    @Override
    public ResultDTO deleteBatch(Long[] ids) {
        try {
            for (Long id : ids) {
                delete(id);
            }
            resultDTO.setCode(200);
            resultDTO.setMsg(Constant.SUCCESS_DELETE);
        } catch (Exception e) {
            resultDTO.setCode(500);
            resultDTO.setMsg(Constant.FAIL_DELETE);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO search(Pageable pageable, String key, String val) {
        try {
            SearchQuery searchQuery = getEntitySearchQuery(pageable, key, val);
            resultDTO.setCode(200);
            resultDTO.setMsg(Constant.SUCCESS);
            Map<String, Object> map = new HashMap<>();
            map.put("message", messageESRepository.search(searchQuery).getContent());
            resultDTO.setResult(map);
        } catch (Exception e) {
            resultDTO.setCode(500);
            resultDTO.setMsg(Constant.FAIL);
        }
        return resultDTO;
    }

    @Override
    public List<MessageESDTO> search(Pageable pageable) {
        return messageESRepository.findAll(pageable).getContent();
    }

    /**
     * @description:组合查询条件
     * @auther: WBA
     * @date: 2019/1/15 18:25
     * @param: [pageable, key, val]
     * @return: org.springframework.data.elasticsearch.core.query.SearchQuery
     */
    private SearchQuery getEntitySearchQuery(Pageable pageable, String key, String val) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.matchPhraseQuery(key, val),
                ScoreFunctionBuilders.weightFactorFunction(100))
                //设置权重分求和模式
                .scoreMode(FiltersFunctionScoreQuery.ScoreMode.SUM)
                //设置权重分最低分
                .setMinScore(10);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder)
                .build();
    }
}