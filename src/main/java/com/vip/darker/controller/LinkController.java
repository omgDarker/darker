package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.LinkDO;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.ConfigConstant;
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
     * @description:链接新增
     * @auther: WBA
     * @date: 2018/12/11 16:53
     * @param: [linkModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/links", method = RequestMethod.POST)
    public Map<String, Object> addLink(LinkDO linkDO) {

        boolean flag = SpringBootService.getLinkService().insert(linkDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_INSERT.getName() : OperationStatusEnum.FAIL_INSERT.getName());

        return map;
    }

    /**
     * @description:链接更新
     * @auther: WBA
     * @date: 2018/12/11 16:53
     * @param: [linkModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/links", method = RequestMethod.PUT)
    public Map<String, Object> updateLink(LinkDO linkDO) {

        boolean flag = SpringBootService.getLinkService().updateById(linkDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_UPDATE.getName() : OperationStatusEnum.FAIL_UPDATE.getName());

        return map;
    }

    /**
     * @description:链接删除
     * @auther: WBA
     * @date: 2018/12/11 16:54
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/links/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteLink(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getLinkService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_DELETE.getName() : OperationStatusEnum.FAIL_DELETE.getName());

        return map;
    }

    /**
     * @description:链接对象查询
     * @auther: WBA
     * @date: 2018/12/11 16:54
     * @param: [id]
     * @return: com.vip.darker.model.LinkModel
     */
    @RequestMapping(value = "/links/{id}")
    public LinkDO findLinkById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getLinkService().selectById(id);
    }

    /**
     * @description:链接列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:54
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.LinkModel>
     */
    @RequestMapping(value = "/links", method = RequestMethod.GET)
    public List<LinkDO> findListLink(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getLinkService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:链接列表页数
     * @auther: WBA
     * @date: 2018/12/11 16:54
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/links/page", method = RequestMethod.GET)
    public Map<String, Object> getLinkPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getLinkService().selectCount(new EntityWrapper<>());

        map.put("linkMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }
}