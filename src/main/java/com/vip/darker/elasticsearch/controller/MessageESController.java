package com.vip.darker.elasticsearch.controller;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import com.vip.darker.elasticsearch.service.MessageESService;
import com.vip.darker.util.Constant;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ESController
 * @auther: WBA
 * @date: 2019/1/11 17:27
 */
@RestController
@RequestMapping(value = "/message")
public class MessageESController {

    private final MessageESService messageESService;

    @Autowired
    public MessageESController(MessageESService messageESService) {
        this.messageESService = messageESService;
    }

    /**
     * @description:索引新增
     * @auther: WBA
     * @date: 2019/1/11 17:59
     * @param: []
     * @return: java.lang.String
     */
    @GetMapping("/add/index")
    public String addIndex() {

        List<MessageDTO> messageDTOS = new ArrayList<>();
        messageDTOS.add(new MessageDTO(4, "湘春夜月·近清明", "近清明,翠禽枝上消魂,可惜一片清歌，都付与黄昏。欲共柳花低诉，怕柳花轻薄，不解伤春。念楚乡旅宿，柔情别绪，谁与温存。"));
        messageDTOS.add(new MessageDTO(5, "卜算子·不是爱风尘", "不是爱风尘，似被前缘误。花落花开自有时，总赖东君主。去也终须去，住也如何住！若得山花插满头，莫问奴归处"));
        messageDTOS.add(new MessageDTO(6, "御街行·秋日怀旧", "纷纷坠叶飘香砌。夜寂静，寒声碎。真珠帘卷玉楼空，天淡银河垂地。年年今夜，月华如练，长是人千里。"));

        for (MessageDTO messageDTO : messageDTOS) {
            messageESService.save(messageDTO);
        }
        return "success";
    }

    /**
     * @description:索引删除
     * @auther: WBA
     * @date: 2019/1/14 18:30
     * @param: [id]
     * @return: void
     */
    @GetMapping("/del/index/{id}")
    public void delIndex(@PathVariable(value = "id") Long id) {
        messageESService.delete(id);
    }

    /**
     * @description:索引检索
     * @auther: WBA
     * @date: 2019/1/11 18:00
     * @param: [pageIndex, pageSize, model]
     * @return: java.lang.String
     */
    @GetMapping("/query/index")
    public List<MessageDTO> queryIndexList(Integer pageNumber, String query) {
        if (pageNumber == null) pageNumber = 0;
        SearchQuery searchQuery = getEntitySearchQuery(pageNumber, query);
        Page<MessageDTO> goodsPage = messageESService.search(searchQuery);
        return goodsPage.getContent();
    }

    /**
     * @description:组装查询条件
     * @auther: WBA
     * @date: 2019/1/14 12:00
     * @param: [pageNumber, searchContent]
     * @return: org.springframework.data.elasticsearch.core.query.SearchQuery
     */
    private SearchQuery getEntitySearchQuery(int pageNumber, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.matchPhraseQuery("content", searchContent),
                ScoreFunctionBuilders.weightFactorFunction(100))
                //设置权重分 求和模式
                .scoreMode(FiltersFunctionScoreQuery.ScoreMode.SUM)
                //设置权重分最低分
                .setMinScore(10);
        // 设置分页
        Pageable pageable = new PageRequest(pageNumber, Constant.PAGE_SIZE);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }
}