package com.vip.darker.controller;

import com.vip.darker.model.Visitor;
import com.vip.darker.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : P2M.WBA
 * @version : 2.9.6
 * @description : 游客controller
 * @date : Create in 2018-07-13 14:02
 */
@RestController // @Controller+@ResponseBody
@RequestMapping(value = "/visitor")
public class VisitorController {

    @Autowired
    @Qualifier(value = "visitorService")
    private VisitorService visitorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int addVisitor(Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @RequestMapping(value = "all/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Object  getAllVisitor(@PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return visitorService.queryAllVisitor(pageNum, pageSize);
    }
}
