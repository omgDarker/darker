package com.vip.darker.controller;

import com.vip.darker.model.Visitor;
import com.vip.darker.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addVisitor(Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public Object getAllVisitor(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return visitorService.queryAllVisitor(pageNum, pageSize);
    }
}
