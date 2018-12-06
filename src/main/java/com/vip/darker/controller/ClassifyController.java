package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ClassifyModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
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
     * 功能描述: 分类新增
     *
     * @param: [classifyModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 23:04
     */
    @RequestMapping(value = "/classifys", method = RequestMethod.POST)
    public Map<String, Object> addClassify(ClassifyModel classifyModel) {

        boolean flag = SpringBootService.getClassifyService().insert(classifyModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

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
    @RequestMapping(value = "/classifys", method = RequestMethod.PUT)
    public Map<String, Object> updateClassify(ClassifyModel classifyModel) {

        boolean flag = SpringBootService.getClassifyService().updateById(classifyModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

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
    @RequestMapping(value = "/classifys/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteClassify(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getClassifyService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 分类对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ClassifyModel
     * @auther: darker
     * @date: 2018/8/15 15:31
     */
    @RequestMapping(value = "/classifys/{id}")
    public ClassifyModel findClassifyById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getClassifyService().selectById(id);
    }

    /**
     * 功能描述: 分类列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ClassifyModel>
     * @auther: darker
     * @date: 2018/8/15 11:42
     */
    @RequestMapping(value = "/classifys", method = RequestMethod.GET)
    public List<ClassifyModel> findListClassify(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getClassifyService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 分类列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/15 10:48
     */
    @RequestMapping(value = "/classifys/page", method = RequestMethod.GET)
    public Map<String, Object> getClassifyPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getClassifyService().selectCount(new EntityWrapper<>());

        map.put("classifyMaxPage", (count - 1) / Constant.PAGE_SIZE + 1);

        return map;
    }
}