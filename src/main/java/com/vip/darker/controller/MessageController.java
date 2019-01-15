package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.convert.ConvertAttribute;
import com.vip.darker.elasticsearch.entity.MessageDTO;
import com.vip.darker.entity.MessageDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/20 15:05
 * @DateUpdate: 2018/8/2
 * @Description: 留言控制器
 */
@RestController
public class MessageController {

    /**
     * @description:留言新增
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: [articleId, messageModel]
     * @return: java.util.Map
     */
    @PostMapping(value = "/messages")
    public Map<String, Object> addMessage(@RequestBody MessageDO messageDO) {
        // 留言新增
        boolean flag = SpringBootService.getMessageService().insert(messageDO);
        // 若新增成功,则将对象添加到索引中
        if (flag) {
            // 应用场景:文章详情页
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setId(messageDO.getId());
            messageDTO.setUsername(messageDO.getUserName());
            messageDTO.setContent(messageDO.getContent());
            SpringBootService.getMessageESService().save(messageDTO);
        }
        // 留言信息列表
        List<MessageDO> messageDOList = SpringBootService.getMessageService().selectList(new EntityWrapper<MessageDO>().where("articleId={0}", messageDO.getArticleId()));

        Map<String, Object> map = new HashMap<>();

        map.put("messageList", messageDOList);

        return map;
    }

    /**
     * @description:留言删除
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: [id]
     * @return: java.util.Map
     */
    @DeleteMapping(value = "/messages/{id}")
    public Map<String, Object> deleteMessage(@PathVariable(value = "id") Long id) {

        boolean flag = SpringBootService.getMessageService().deleteById(id.intValue());
        // 若删除成功,则将对象从索引中移除
        if (flag) {
            SpringBootService.getMessageESService().delete(id);
        }
        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * @description:留言列表页数
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: []
     * @return: java.util.Map
     */
    @GetMapping(value = "/messages/page")
    public Map<String, Object> countMessagePage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getMessageService().selectCount(new EntityWrapper<>());

        map.put("messageMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * @description:留言对象查询
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: [id]
     * @return: com.vip.darker.model.MessageModel
     */
    @GetMapping(value = "/messages/{id}")
    public MessageDO findMessageById(@PathVariable(value = "id") long id) {
        return SpringBootService.getMessageService().selectById(id);
    }

    /**
     * @description:留言列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:57
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MessageModel>
     */
    @GetMapping(value = "/messages")
    public List<MessageDO> findListMessage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:留言板
     * @auther: WBA
     * @date: 2018/12/11 16:57
     * @param: [pageNum, pageSize]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping(value = "/home/messages")
    public ModelAndView findMessageBoard(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 跳转页
        ModelAndView modelAndView = new ModelAndView("home/message");
        // 当前页
        modelAndView.addObject("pageNum", pageNum);
        // 留言列表
        modelAndView.addObject("messageList", SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords());
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());

        return modelAndView;
    }
}