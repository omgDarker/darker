package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(@Qualifier(value = "resourceService") ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * 资源新增
     *
     * @param resourceModel
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addResource(ResourceModel resourceModel) {
        return resourceService.insert(resourceModel);
    }

    /**
     * 资源更新
     *
     * @param resourceModel
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateResource(@RequestBody ResourceModel resourceModel) {
        return resourceService.updateById(resourceModel);
    }

    /**
     * 资源更新{id}
     *
     * @param id
     * @param resourceModel
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public boolean updateResourceById(@PathVariable(value = "id") Integer id, @RequestBody ResourceModel resourceModel) {
        return resourceService.update(resourceModel, new EntityWrapper<ResourceModel>().eq("id", id));
    }

    /**
     * 资源删除(AR模式<-效率低->)
     *
     * @param resourceModel
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteReource(@RequestBody ResourceModel resourceModel) {
        return resourceModel.deleteById();
    }

    /**
     * 资源删除{id}
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteReouseceById(@PathVariable(value = "id") Integer id) {
        return resourceService.deleteById(id);
    }

    /**
     * 资源分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ResourceModel> queryAllResource(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return resourceService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
