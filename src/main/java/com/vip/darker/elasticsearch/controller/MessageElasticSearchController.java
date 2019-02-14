package com.vip.darker.elasticsearch.controller;

import com.vip.darker.elasticsearch.entity.MessageElaticsSearchDTO;
import com.vip.darker.elasticsearch.entity.QueryParamDTO;
import com.vip.darker.vo.ResultVO;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: ESController
 * @auther: WBA
 * @date: 2019/1/11 17:27
 */
@RestController
@RequestMapping(value = "/message")
public class MessageElasticSearchController {

    /**
     * @description:索引新增
     * @auther: WBA
     * @date: 2019/1/11 17:59
     * @param: []
     * @return: java.lang.String
     */
    @PostMapping("/add/index")
    public ResultVO addIndex(@RequestBody List<MessageElaticsSearchDTO> messageElaticsSearchDTOList) {
        return SpringBootService.getMessageESService().saveBatch(messageElaticsSearchDTOList);
    }

    /**
     * @description:索引删除
     * @auther: WBA
     * @date: 2019/1/14 18:30
     * @param: [id]
     * @return: void
     */
    @DeleteMapping("/del/index/{id}")
    public ResultVO delIndex(@PathVariable(value = "id") Long id) {
        return SpringBootService.getMessageESService().delete(id);
    }

    /**
     * @description:索引批量删除
     * @auther: WBA
     * @date: 2019/1/15 15:59
     * @param: [ids]
     * @return: com.vip.darker.entity.ResultDTO
     */
    @PostMapping("del/index")
    public ResultVO delAllIndex(@RequestBody Long[] ids) {
        return SpringBootService.getMessageESService().deleteBatch(ids);
    }

    /**
     * @description:索引检索
     * @auther: WBA
     * @date: 2019/1/15 18:26
     * @param: [pageNum, pageSize, queryParamDTO]
     * @return: com.vip.darker.entity.ResultDTO
     */
    @GetMapping("/search/index")
    public ResultVO searchIndexList(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                    @RequestBody QueryParamDTO queryParamDTO) {
        return SpringBootService.getMessageESService().search(PageRequest.of(pageNum, pageSize), queryParamDTO);
    }
}