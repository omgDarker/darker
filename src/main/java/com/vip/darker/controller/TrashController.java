package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.entity.TrashDO;
import com.vip.darker.enums.OperationStatusEnum;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.CommonConstant;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/12/06 11:51
 * @Description: 回收站控制器
 */
@RestController
public class TrashController {

    /**
     * 操作结果集
     */
    Map<String, Object> map = new HashMap<>(CommonConstant.MAP_DEFAULT_INITIAL_CAPACITY);

    /**
     * @description:回收站删除
     * @auther: WBA
     * @date: 2018/12/11 16:59
     * @param: [id]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/trashs/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteTrash(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getTrashService().deleteById(id);

        map.put(CommonConstant.MSG, flag ? OperationStatusEnum.SUCCESS_DELETE.getName() : OperationStatusEnum.FAIL_DELETE.getName());

        return map;
    }

    /**
     * @description:回收站列表查询
     * @auther: WBA
     * @date: 2018/12/11 16:59
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.TrashModel>
     */
    @RequestMapping(value = "/trashs", method = RequestMethod.GET)
    public List<TrashDO> findListTrash(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getTrashService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:回收站列表页数
     * @auther: WBA
     * @date: 2018/12/11 16:59
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/trashs/page", method = RequestMethod.GET)
    public Map<String, Object> getTrashPage() {

        int count = SpringBootService.getTrashService().selectCount(new EntityWrapper<>());

        map.put("trashMaxPage", (count - 1) / CommonConstant.PAGE_SIZE + 1);

        return map;
    }
}