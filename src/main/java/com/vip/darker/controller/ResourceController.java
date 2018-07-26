package com.vip.darker.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.controller.base.BaseController;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.model.TrashModel;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
public class ResourceController extends BaseController {

    /**
     * 功能描述: 资源新增
     *
     * @param: [resourceModel]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/7/26 15:32
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addResource(ResourceModel resourceModel) {

        boolean flag = SystemServiceLocator.getResourceService().insert(resourceModel);

        ModelAndView model = new ModelAndView(Constant.ADMIN_HOME_REDIRECT);

        model.addObject("msg", flag ? "新增成功!" : "新增失败!");

        return model;
    }

    /**
     * 功能描述: 资源更新
     *
     * @param: [resourceModel]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/7/26 15:33
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ModelAndView updateResource(ResourceModel resourceModel) {

        boolean flag = SystemServiceLocator.getResourceService().updateById(resourceModel);

        ModelAndView model = new ModelAndView(Constant.ADMIN_HOME_REDIRECT);

        model.addObject("msg", flag ? "更新成功!" : "更新失败!");

        return model;
    }

    /**
     * 功能描述: 资源删除[id]
     *
     * @param: [id]
     * @return: java.util.Map
     * @auther: darker
     * @date: 2018/7/25 18:33
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteReouseceById(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getResourceService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 资源实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ResourceModel
     * @auther: darker
     * @date: 2018/7/25 22:25
     */
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResourceModel queryResouceById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getResourceService().selectById(id);
    }

    /**
     * 功能描述: 资源分页查询
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
        return SystemServiceLocator.getResourceService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
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
        return SystemServiceLocator.getTrashService().insert(trashModel);
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
        return SystemServiceLocator.getTrashService().updateById(trashModel);
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
        return SystemServiceLocator.getTrashService().deleteById(id);
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
        return SystemServiceLocator.getTrashService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
