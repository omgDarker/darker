package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.LinkModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/12/06 11:34
 * @Description: 链接控制器
 */
@RestController
public class LinkController {

    /**
     * 功能描述: 链接新增
     *
     * @param: [linkModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/17 23:04
     */
    @RequestMapping(value = "/links", method = RequestMethod.POST)
    public Map<String, Object> addLink(LinkModel linkModel) {

        boolean flag = SpringBootService.getLinkService().insert(linkModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

        return map;
    }

    /**
     * 功能描述: 链接更新
     *
     * @param: [linkModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/17 11:37
     */
    @RequestMapping(value = "/link", method = RequestMethod.PUT)
    public Map<String, Object> updateLink(LinkModel linkModel) {

        boolean flag = SpringBootService.getLinkService().updateById(linkModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * 功能描述: 链接删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:39
     */
    @RequestMapping(value = "/links/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteLink(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getLinkService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 链接对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.LinkModel
     * @auther: darker
     * @date: 2018/8/17 15:31
     */
    @RequestMapping(value = "/links/{id}")
    public LinkModel findLinkById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getLinkService().selectById(id);
    }

    /**
     * 功能描述: 链接列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ClassifyModel>
     * @auther: darker
     * @date: 2018/8/17 11:42
     */
    @RequestMapping(value = "/links", method = RequestMethod.GET)
    public List<LinkModel> findListLink(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getLinkService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 链接列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/17 10:48
     */
    @RequestMapping(value = "/links/page", method = RequestMethod.GET)
    public Map<String, Object> getLinkPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getLinkService().selectCount(new EntityWrapper<>());

        map.put("linkMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }
}