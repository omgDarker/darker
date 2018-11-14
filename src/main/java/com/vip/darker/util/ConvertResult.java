package com.vip.darker.util;

import com.vip.darker.model.ResultModel;

import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/11/13 16:23
 * @Description: 结果集转换工具
 */
public class ConvertResult {

    /**
     * @param code 操作码
     * @param map  操作结果集
     * @return
     */
    public static ResultModel result(int code, Map<String, Object> map) {
        ResultModel model = new ResultModel();
        model.setCode(code);
        model.setResult(map);
        switch (code) {
            case 0:
                model.setMsg(Constant.SUCCESS);
                break;
            case 404:
                model.setMsg("404");
                break;
            case 500:
                model.setMsg("500");
                break;
            default:
                model.setMsg(Constant.FAIL);
                break;
        }
        return model;
    }
}