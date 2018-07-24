package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.model.TrashModel;
import com.vip.darker.service.ResourceService;
import com.vip.darker.service.TrashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 21:55
 * @Description: 资源管理controller
 */
@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    private final ResourceService resourceService;
    private final TrashService trashService;

    @Autowired
    public ResourceController(
            @Qualifier(value = "resourceService") ResourceService resourceService,
            @Qualifier(value = "trashService") TrashService trashService) {
        this.resourceService = resourceService;
        this.trashService = trashService;
    }

    /**
     * 功能描述:资源新增
     *
     * @param: [resourceModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 21:59
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addResource(ResourceModel resourceModel) {
        return resourceService.insert(resourceModel);
    }

    /**
     * 功能描述: 资源更新
     *
     * @param: [resourceModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:00
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateResource(ResourceModel resourceModel) {
        return resourceService.updateById(resourceModel);
    }

    /**
     * 功能描述: 资源更新
     *
     * @param: [id, resourceModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:00
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public boolean updateResourceById(@PathVariable(value = "id") Integer id, @RequestBody ResourceModel resourceModel) {
        return resourceService.update(resourceModel, new EntityWrapper<ResourceModel>().eq("id", id));
    }

    /**
     * 功能描述: 资源删除(AR模式<-效率低->)
     *
     * @param: [resourceModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:01
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteReource(@RequestBody ResourceModel resourceModel) {
        return resourceModel.deleteById();
    }

    /**
     * 功能描述: 资源删除{id}
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:01
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteReouseceById(@PathVariable(value = "id") Integer id) {
        return resourceService.deleteById(id);
    }

    /**
     * 功能描述: 资源查询分页
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ResourceModel>
     * @auther: darker
     * @date: 2018/7/19 22:02
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ResourceModel> queryAllResource(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return resourceService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 回收站资源新增
     *
     * @param: [trashModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 12:03
     */
    @RequestMapping(value = "/addTrash", method = RequestMethod.POST)
    public boolean addTrash(TrashModel trashModel) {
        return trashService.insert(trashModel);
    }

    /**
     * 功能描述: 回收站资源更新
     *
     * @param: [trashModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 12:06
     */
    @RequestMapping(value = "/updateTrash", method = RequestMethod.PUT)
    public boolean updateTrash(@RequestBody TrashModel trashModel) {
        return trashService.updateById(trashModel);
    }

    /**
     * 功能描述: 回收站资源删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 12:08
     */
    @RequestMapping(value = "/deleteTrash/{id}", method = RequestMethod.DELETE)
    public boolean deleteTrash(@PathVariable(value = "id") Integer id) {
        return trashService.deleteById(id);
    }

    /**
     * 功能描述: 回收站资源分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.TrashModel>
     * @auther: darker
     * @date: 2018/7/20 12:11
     */
    @RequestMapping(value = "/allTrash", method = RequestMethod.GET)
    public List<TrashModel> queryAllTrash(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return trashService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
