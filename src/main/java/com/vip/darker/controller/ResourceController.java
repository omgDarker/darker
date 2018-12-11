package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 21:55
 * @DateUpdate: 2018/7/30
 * @Description: 资源控制器
 */
@RestController
public class ResourceController {

    /**
     * @description:资源新增
     * @auther: WBA
     * @date: 2018/12/11 16:58
     * @param: [resourceModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/resources", method = RequestMethod.POST)
    public Map<String, Object> addResource(ResourceModel resourceModel) {

        boolean flag = SpringBootService.getResourceService().insert(resourceModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

        return map;
    }

    /**
     * @description:资源更新
     * @auther: WBA
     * @date: 2018/12/11 16:58
     * @param: [resourceModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/resources", method = RequestMethod.PUT)
    public Map<String, Object> editResource(ResourceModel resourceModel) {

        boolean flag = SpringBootService.getResourceService().updateById(resourceModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * @description:资源删除
     * @auther: WBA
     * @date: 2018/12/11 16:58
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteReouseceById(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getResourceService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * @description:资源对象查询
     * @auther: WBA
     * @date: 2018/12/11 16:58
     * @param: [id]
     * @return: com.vip.darker.model.ResourceModel
     */
    @RequestMapping(value = "/resources/{id}", method = RequestMethod.GET)
    public ResourceModel findResouceById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getResourceService().selectById(id);
    }

    /**
     * @description:资源列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:58
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ResourceModel>
     */
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public List<ResourceModel> findListResource(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return SpringBootService.getResourceService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}