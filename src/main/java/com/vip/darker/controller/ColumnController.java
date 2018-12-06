package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ColumnModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @description ：栏目控制器
 * @date : 2018/12/06 10:41
 */
@RestController
public class ColumnController {

    /**
     * 功能描述: 栏目新增
     *
     * @param: [columnModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 23:04
     */
    @RequestMapping(value = "/columns", method = RequestMethod.POST)
    public Map<String, Object> addColumn(ColumnModel columnModel) {

        boolean flag = SpringBootService.getColumnService().insert(columnModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

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
    @RequestMapping(value = "/columns", method = RequestMethod.PUT)
    public Map<String, Object> updateColumn(ColumnModel columnModel) {

        boolean flag = SpringBootService.getColumnService().updateById(columnModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

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
    @RequestMapping(value = "/columns/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteColumn(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getColumnService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 栏目对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ColumnModel
     * @auther: darker
     * @date: 2018/8/15 15:31
     */
    @RequestMapping(value = "/columns/{id}")
    public ColumnModel queryColumnById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getColumnService().selectById(id);
    }

    /**
     * 功能描述: 栏目列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ColumnModel>
     * @auther: darker
     * @date: 2018/8/15 11:42
     */
    @RequestMapping(value = "/columns", method = RequestMethod.GET)
    public List<ColumnModel> findListColumn(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getColumnService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 栏目列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 10:48
     */
    @RequestMapping(value = "/columns/page", method = RequestMethod.GET)
    public Map<String, Object> getColumnPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getColumnService().selectCount(new EntityWrapper<>());

        map.put("columnMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * 功能描述: 根据分类ID查询栏目列表
     *
     * @param: [classifyId]
     * @return: java.util.List<com.vip.darker.model.ColumnModel>
     * @auther: darker
     * @date: 2018/9/4 10:36
     */
    @RequestMapping(value = "/columns/{classifyId}", method = RequestMethod.GET)
    public List<ColumnModel> findColumnByClassifyId(@PathVariable(value = "classifyId") Integer[] classifyId) {
        return SpringBootService.getColumnService().selectList(new EntityWrapper<ColumnModel>().in("classifyId", classifyId));
    }
}