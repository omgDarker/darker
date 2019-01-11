package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.MessageDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.convert.ConvertAttribute;
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
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public Map<String, Object> addMessage(Integer articleId, MessageDO messageDO) {
        // 留言新增
        SpringBootService.getMessageService().insert(messageDO);
        // 留言信息
        List<MessageDO> messageDOList = SpringBootService.getMessageService().selectList(new EntityWrapper<MessageDO>().where("articleId={0}", articleId));

        Map<String, Object> map = new HashMap<>();

        map.put("messageList", messageDOList);

        return map;
    }

    /**
     * @description:留言更新
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: [messageModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/messages", method = RequestMethod.PUT)
    public Map<String, Object> editMessage(MessageDO messageDO) {

        boolean flag = SpringBootService.getMessageService().updateById(messageDO);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * @description:留言删除
     * @auther: WBA
     * @date: 2018/12/11 16:56
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteMessage(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getMessageService().deleteById(id);

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
    @RequestMapping(value = "/messages/page", method = RequestMethod.GET)
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
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public MessageDO findMessageById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getMessageService().selectById(id);
    }

    /**
     * @description:留言列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:57
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.MessageModel>
     */
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<MessageDO> findListMessage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getMessageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:留言板
     * @auther: WBA
     * @date: 2018/12/11 16:57
     * @param: [pageNum, pageSize]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/home/messages", method = RequestMethod.GET)
    public ModelAndView findMessageBoard(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
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