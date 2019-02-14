package com.vip.darker.elasticsearch.service.impl;

import com.vip.darker.annotation.BKDefinition;
import com.vip.darker.elasticsearch.dao.MessageElasticSearchRepository;
import com.vip.darker.elasticsearch.entity.MessageElaticsSearchDTO;
import com.vip.darker.elasticsearch.entity.QueryParamDTO;
import com.vip.darker.elasticsearch.service.MessageESService;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.vo.ResultVO;
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

    private final MessageElasticSearchRepository messageElasticSearchRepository;
    @BKDefinition(value = "接收结果集")
    private ResultVO resultVO = new ResultVO();

    @Autowired
    public MessageESServiceImpl(MessageElasticSearchRepository messageElasticSearchRepository) {
        this.messageElasticSearchRepository = messageElasticSearchRepository;
    }

    @Override
    public ResultVO save(MessageElaticsSearchDTO messageElaticsSearchDTO) {
        try {
            messageElasticSearchRepository.save(messageElaticsSearchDTO);
            resultVO.setCode(200);
            resultVO.setMsg(OperationStatusEnum.SUCCESS_INSERT.getName());
        } catch (Exception e) {
            resultVO.setCode(500);
            resultVO.setMsg(OperationStatusEnum.FAIL_INSERT.getName());
        }
        return resultVO;
    }

    @Override
    public ResultVO saveBatch(List<MessageElaticsSearchDTO> messageElaticsSearchDTOList) {
        try {
            messageElasticSearchRepository.saveAll(messageElaticsSearchDTOList);
            resultVO.setCode(200);
            resultVO.setMsg(OperationStatusEnum.SUCCESS_INSERT.getName());
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setCode(500);
            resultVO.setMsg(OperationStatusEnum.FAIL_INSERT.getName());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        try {
            messageElasticSearchRepository.deleteById(id);
            resultVO.setCode(200);
            resultVO.setMsg(OperationStatusEnum.SUCCESS_DELETE.getName());
        } catch (Exception e) {
            resultVO.setCode(500);
            resultVO.setMsg(OperationStatusEnum.FAIL_DELETE.getName());
        }
        return resultVO;

    }

    @Override
    public ResultVO deleteBatch(Long[] ids) {
        try {
            for (Long id : ids) {
                delete(id);
            }
            resultVO.setCode(200);
            resultVO.setMsg(OperationStatusEnum.SUCCESS_DELETE.getName());
        } catch (Exception e) {
            resultVO.setCode(500);
            resultVO.setMsg(OperationStatusEnum.FAIL_DELETE.getName());
        }
        return resultVO;
    }

    @Override
    public ResultVO search(Pageable pageable, QueryParamDTO queryParamDTO) {
        try {
            SearchQuery searchQuery = getEntitySearchQuery(pageable, queryParamDTO);
            resultVO.setCode(200);
            resultVO.setMsg(OperationStatusEnum.SUCCESS.getName());
            Map<String, Object> map = new HashMap<>();
            map.put("message", messageElasticSearchRepository.search(searchQuery).getContent());
            resultVO.setResult(map);
        } catch (Exception e) {
            resultVO.setCode(500);
            resultVO.setMsg(OperationStatusEnum.FAIL.getName());
        }
        return resultVO;
    }

    @Override
    public List<MessageElaticsSearchDTO> search(Pageable pageable) {
        return messageElasticSearchRepository.findAll(pageable).getContent();
    }

    /**
     * @description:组合查询条件
     * @auther: WBA
     * @date: 2019/1/15 18:25
     * @param: [pageable, key, val]
     * @return: org.springframework.data.elasticsearch.core.query.SearchQuery
     */
    private SearchQuery getEntitySearchQuery(Pageable pageable, QueryParamDTO queryParamDTO) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.matchPhraseQuery(queryParamDTO.getKey(), queryParamDTO.getVal()),
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