package com.vip.darker.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.constant.CommonConstant;
import com.vip.darker.convert.ConvertResult;
import com.vip.darker.entity.ArticleDO;
import com.vip.darker.entity.MessageDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.vo.ResultVO;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: Darker
 * @Date: 2018/11/13 16:14
 * @Description: restful API
 */
@RestController
@RequestMapping(value = "/darker/api")
@Scope(value = "prototype")
public class ApiController {
    /**
     * 操作结果集
     */
    private Map<String, Object> map = new HashMap<>(CommonConstant.MAP_DEFAULT_INITIAL_CAPACITY);

    /**
     * @description: 文章列表API
     * @auther: WBA
     * @date: 2018/12/11 16:36
     * @param: []
     * @return: com.vip.darker.model.ResultModel
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResultVO findListArticle() {
        Optional<List<ArticleDO>> optional = Optional.ofNullable(SpringBootService.getArticleService().selectList(new EntityWrapper<>()));

        if (optional.isPresent()) {
            map.put("article", optional.get());
            return ConvertResult.result(0, map);
        }
        return ConvertResult.result(-1, map);
    }

    /**
     * @description: 消息列表API
     * @auther: WBA
     * @date: 2018/12/11 16:36
     * @param: []
     * @return: com.vip.darker.model.ResultModel
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ResultVO findListMessage() {
        Optional<List<MessageDO>> optional = Optional.ofNullable(SpringBootService.getMessageService().selectList(new EntityWrapper<>()));

        if (optional.isPresent()) {
            map.put("message", optional.get());
            return ConvertResult.result(0, map);
        }
        return ConvertResult.result(-1, map);
    }
}