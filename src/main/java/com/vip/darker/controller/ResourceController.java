package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.model.TrashModel;
import com.vip.darker.service.ResourceService;
import com.vip.darker.service.TrashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 21:55
 * @Description: 资源管理controller
 */
@Controller
@RequestMapping(value = "resource")
public class ResourceController {

    private final ResourceService resourceService;
    private final TrashService trashService;

    @Autowired
    public ResourceController(@Qualifier(value = "resourceService") ResourceService resourceService, @Qualifier(value = "trashService") TrashService trashService) {
        this.resourceService = resourceService;
        this.trashService = trashService;
    }

    /**
     * 功能描述:资源新增
     *
     * @param: [resourceModel]
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/7/19 21:59
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addResource(Model model, ResourceModel resourceModel) {

        boolean flag = resourceService.insert(resourceModel);

        if (flag) {
            model.addAttribute("msg", "数据新增成功!");
        } else {
            model.addAttribute("msg", "数据新增失败!");
        }
        return "redirect:/admin/home";
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
     * 功能描述: 资源删除[id]
     *
     * @param: [id]
     * @return: java.util.Map<java.lang.String , java.lang.String>
     * @auther: darker
     * @date: 2018/7/25 18:33
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> deleteReouseceById(@PathVariable(value = "id") Integer id) {

        boolean flag = resourceService.deleteById(id);

        Map<String, String> map = new HashMap<>();

        if (flag) {
            map.put("msg", "删除成功!");
        } else {
            map.put("msg", "删除失败!");
        }
        return map;
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
    public List<ResourceModel> queryAllResource(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
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
    public List<TrashModel> queryAllTrash(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return trashService.selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
