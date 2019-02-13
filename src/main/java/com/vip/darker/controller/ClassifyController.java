package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.ClassifyDO;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.ConfigConstant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @description ：分类控制器
 * @date : 2018/12/06 11:44
 */
@RestController
public class ClassifyController {

    /**
     * @description:分类新增
     * @auther: WBA
     * @date: 2018/12/11 16:47
     * @param: [classifyModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/classifys", method = RequestMethod.POST)
    public Map<String, Object> addClassify(ClassifyDO classifyDO) {

        boolean flag = SpringBootService.getClassifyService().insert(classifyDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_INSERT.getName() : OperationStatusEnum.FAIL_INSERT.getName());

        return map;
    }

    /**
     * @description:分类更新
     * @auther: WBA
     * @date: 2018/12/11 16:47
     * @param: [classifyModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/classifys", method = RequestMethod.PUT)
    public Map<String, Object> updateClassify(ClassifyDO classifyDO) {

        boolean flag = SpringBootService.getClassifyService().updateById(classifyDO);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_UPDATE.getName() : OperationStatusEnum.FAIL_UPDATE.getName());

        return map;
    }

    /**
     * @description:分类删除
     * @auther: WBA
     * @date: 2018/12/11 16:48
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/classifys/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteClassify(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getClassifyService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(ConfigConstant.MSG, flag ? OperationStatusEnum.SUCCESS_DELETE.getName() : OperationStatusEnum.FAIL_DELETE.getName());

        return map;
    }

    /**
     * @description: 分类对象查询
     * @auther: WBA
     * @date: 2018/12/11 16:48
     * @param: [id]
     * @return: com.vip.darker.model.ClassifyModel
     */
    @RequestMapping(value = "/classifys/{id}")
    public ClassifyDO findClassifyById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getClassifyService().selectById(id);
    }

    /**
     * @description:分类列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:48
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ClassifyModel>
     */
    @RequestMapping(value = "/classifys", method = RequestMethod.GET)
    public List<ClassifyDO> findListClassify(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getClassifyService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:分类列表页数
     * @auther: WBA
     * @date: 2018/12/11 16:48
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/classifys/page", method = RequestMethod.GET)
    public Map<String, Object> getClassifyPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getClassifyService().selectCount(new EntityWrapper<>());

        map.put("classifyMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }
}