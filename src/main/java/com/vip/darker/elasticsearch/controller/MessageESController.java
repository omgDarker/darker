package com.vip.darker.elasticsearch.controller;

import com.vip.darker.elasticsearch.entity.MessageDTO;
import com.vip.darker.elasticsearch.service.MessageESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ESController
 * @auther: WBA
 * @date: 2019/1/11 17:27
 */
@Controller
@RequestMapping(value = "/es")
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
    @RequestMapping("/add/index")
    public String addIndex() {
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messageDTOS.add(new MessageDTO(4, "湘春夜月·近清明", "近清明,翠禽枝上消魂,可惜一片清歌，都付与黄昏。欲共柳花低诉，怕柳花轻薄，不解伤春。念楚乡旅宿，柔情别绪，谁与温存。"));
        messageDTOS.add(new MessageDTO(5, "卜算子·不是爱风尘", "不是爱风尘，似被前缘误。花落花开自有时，总赖东君主。去也终须去，住也如何住！若得山花插满头，莫问奴归处"));
        messageDTOS.add(new MessageDTO(6, "御街行·秋日怀旧", "纷纷坠叶飘香砌。夜寂静，寒声碎。真珠帘卷玉楼空，天淡银河垂地。年年今夜，月华如练，长是人千里。"));

        for (MessageDTO messageDTO : messageDTOS) {
            messageESService.save(messageDTO);
        }
        return "/index";

    }

    /**
     * @description:索引检索
     * @auther: WBA
     * @date: 2019/1/11 18:00
     * @param: [pageIndex, pageSize, model]
     * @return: java.lang.String
     */
    @RequestMapping("/query/index")
    @SuppressWarnings(value = "all")
    public String queryIndex(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            Model model) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page MessageDTO = messageESService.findAll(pageable);
        model.addAttribute("poems", MessageDTO);
        return "/index";
    }
}