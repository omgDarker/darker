package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.ColumnDO;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.ConfigConstant;
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
     * @description:栏目新增
     * @auther: WBA
     * @date: 2018/12/11 16:49
     * @param: [columnModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/columns", method = RequestMethod.POST)
    public Map<String, Object> addColumn(ColumnDO columnDO) {

        boolean flag = SpringBootService.getColumnService().insert(columnDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_INSERT.getName() : OperationStatusEnum.FAIL_INSERT.getName());

        return map;
    }

    /**
     * @description:栏目更新
     * @auther: WBA
     * @date: 2018/12/11 16:49
     * @param: [columnModel]
     * @return: java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     */
    @RequestMapping(value = "/columns", method = RequestMethod.PUT)
    public Map<String, Object> updateColumn(ColumnDO columnDO) {

        boolean flag = SpringBootService.getColumnService().updateById(columnDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_UPDATE.getName() : OperationStatusEnum.FAIL_UPDATE.getName());

        return map;
    }

    /**
     * @description:栏目删除
     * @auther: WBA
     * @date: 2018/12/11 16:49
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/columns/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteColumn(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getColumnService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_DELETE.getName() : OperationStatusEnum.FAIL_DELETE.getName());

        return map;
    }

    /**
     * @description:栏目对象查询
     * @auther: WBA
     * @date: 2018/12/11 16:49
     * @param: [id]
     * @return: com.vip.darker.model.ColumnModel
     */
    @RequestMapping(value = "/columns/{id}")
    public ColumnDO queryColumnById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getColumnService().selectById(id);
    }

    /**
     * @description:栏目列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:50
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ColumnModel>
     */
    @RequestMapping(value = "/columns", method = RequestMethod.GET)
    public List<ColumnDO> findListColumn(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getColumnService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:栏目列表页数
     * @auther: WBA
     * @date: 2018/12/11 16:50
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/columns/page", method = RequestMethod.GET)
    public Map<String, Object> getColumnPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getColumnService().selectCount(new EntityWrapper<>());

        map.put("columnMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }

    /**
     * @description:根据分类ID查询栏目列表
     * @auther: WBA
     * @date: 2018/12/11 16:50
     * @param: [classifyId]
     * @return: java.util.List<com.vip.darker.model.ColumnModel>
     */
    @RequestMapping(value = "/columns/{classifyId}", method = RequestMethod.GET)
    public List<ColumnDO> findColumnByClassifyId(@PathVariable(value = "classifyId") Integer[] classifyId) {
        return SpringBootService.getColumnService().selectList(new EntityWrapper<ColumnDO>().in("classifyId", classifyId));
    }
}