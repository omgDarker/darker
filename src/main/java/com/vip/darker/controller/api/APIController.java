package com.vip.darker.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.model.MessageModel;
import com.vip.darker.model.ResultModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.ConvertResult;
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
public class APIController {
    // 操作结果集
    private Map<String, Object> map = new HashMap<>();

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResultModel queryArticle() {
        Optional<List<ArticleModel>> optional = Optional.ofNullable(SpringBootService.getArticleService().selectList(new EntityWrapper<>()));

        if (optional.isPresent()) {
            map.put("article", optional.get());
            return ConvertResult.result(0, map);
        }
        return ConvertResult.result(-1, map);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ResultModel queryMessage() {
        Optional<List<MessageModel>> optional = Optional.ofNullable(SpringBootService.getMessageService().selectList(new EntityWrapper<>()));

        if (optional.isPresent()) {
            map.put("message", optional.get());
            return ConvertResult.result(0, map);
        }
        return ConvertResult.result(-1, map);
    }
}