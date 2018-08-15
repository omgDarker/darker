package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.controller.base.BaseController;
import com.vip.darker.model.*;
import com.vip.darker.system.locator.SystemServiceLocator;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 21:55
 * @DateUpdate: 2018/7/30
 * @Description: 资源管理controller
 */
@RestController
@RequestMapping(value = "resource")
public class ResourceController extends BaseController {

    //****************************************资源模块****************************************//

    /**
     * 功能描述: 资源新增
     *
     * @param: [resourceModel]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: darker
     * @date: 2018/7/26 15:32
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addResource(ResourceModel resourceModel) {

        boolean flag = SystemServiceLocator.getResourceService().insert( resourceModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

        return map;
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
    public Map<String, Object> updateResource(ResourceModel resourceModel) {

        boolean flag = SystemServiceLocator.getResourceService().updateById( resourceModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

        return map;
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
    public Map<String, Object> deleteReouseceById(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getResourceService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

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
    public ResourceModel queryResouceById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getResourceService().selectById( id );
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
    public List<ResourceModel> queryAllResource(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return SystemServiceLocator.getResourceService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    //****************************************回收站模块****************************************//

    /**
     * 功能描述: 回收站资源删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 12:08
     */
    @RequestMapping(value = "/deleteTrash/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteTrash(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getTrashService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE );

        return map;
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
        return SystemServiceLocator.getTrashService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    /**
     * 功能描述: 回收站分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/trashMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getTrashMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getTrashService().selectCount( new EntityWrapper<>() );

        map.put( "trashMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return map;
    }

    //****************************************分类模块****************************************//

    /**
     * 功能描述: 分类新增
     *
     * @param: [classifyModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 23:04
     */
    @RequestMapping(value = "/addClassify", method = RequestMethod.POST)
    public Map<String, Object> addClassify(ClassifyModel classifyModel) {

        boolean flag = SystemServiceLocator.getClassifyService().insert( classifyModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

        return map;
    }

    /**
     * 功能描述: 分类更新
     *
     * @param: [classifyModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 11:37
     */
    @RequestMapping(value = "/updateClassify", method = RequestMethod.PUT)
    public Map<String, Object> updateClassify(ClassifyModel classifyModel) {

        boolean flag = SystemServiceLocator.getClassifyService().updateById( classifyModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

        return map;
    }

    /**
     * 功能描述: 分类删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:39
     */
    @RequestMapping(value = "/deleteClassify/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteClassify(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getClassifyService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE: Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 分类实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ClassifyModel
     * @auther: darker
     * @date: 2018/8/15 15:31
     */
    @RequestMapping(value = "/allClassify/{id}")
    public ClassifyModel queryClassifyById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getClassifyService().selectById( id );
    }

    /**
     * 功能描述: 分类分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ClassifyModel>
     * @auther: darker
     * @date: 2018/8/15 11:42
     */
    @RequestMapping(value = "/allClassify", method = RequestMethod.GET)
    public List<ClassifyModel> queryAllClassify(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getClassifyService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    /**
     * 功能描述: 分类分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 10:48
     */
    @RequestMapping(value = "/classifyMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getClassifyMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getClassifyService().selectCount( new EntityWrapper<>() );

        map.put( "classifyMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return map;
    }

    //****************************************栏目模块****************************************//

    /**
     * 功能描述: 栏目新增
     *
     * @param: [columnModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 23:04
     */
    @RequestMapping(value = "/addColumn", method = RequestMethod.POST)
    public Map<String, Object> addColumn(ColumnModel columnModel) {

        boolean flag = SystemServiceLocator.getColumnService().insert( columnModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT );

        return map;
    }

    /**
     * 功能描述: 栏目更新
     *
     * @param: [columnModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 11:37
     */
    @RequestMapping(value = "/updateColumn", method = RequestMethod.PUT)
    public Map<String, Object> updateColumn(ColumnModel columnModel) {

        boolean flag = SystemServiceLocator.getColumnService().updateById( columnModel );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE );

        return map;
    }

    /**
     * 功能描述: 栏目删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:39
     */
    @RequestMapping(value = "/deleteColumn/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteColumn(@PathVariable(value = "id") Integer id) {

        boolean flag = SystemServiceLocator.getColumnService().deleteById( id );

        Map<String, Object> map = new HashMap<>();

        map.put( Constant.MSG, flag ? Constant.SUCCESS_DELETE: Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 栏目实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ColumnModel
     * @auther: darker
     * @date: 2018/8/15 15:31
     */
    @RequestMapping(value = "/allColumn/{id}")
    public ColumnModel queryColumnById(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getColumnService().selectById( id );
    }

    /**
     * 功能描述: 栏目分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ColumnModel>
     * @auther: darker
     * @date: 2018/8/15 11:42
     */
    @RequestMapping(value = "/allColumn", method = RequestMethod.GET)
    public List<ColumnModel> queryAllColumn(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SystemServiceLocator.getColumnService().selectPage( new Page<>( pageNum, pageSize ) ).getRecords();
    }

    /**
     * 功能描述: 栏目分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 10:48
     */
    @RequestMapping(value = "/columnMaxPage", method = RequestMethod.GET)
    public Map<String, Object> getColumnMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SystemServiceLocator.getColumnService().selectCount( new EntityWrapper<>() );

        map.put( "columnMaxPage", (count - 1) / Constant.PAGE_SIZE + 1 );

        return map;
    }
}
