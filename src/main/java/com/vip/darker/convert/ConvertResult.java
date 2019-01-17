package com.vip.darker.convert;

import com.vip.darker.vo.ResultVO;
import com.vip.darker.util.Constant;

import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/11/13 16:23
 * @Description: 结果集转换工具类
 */
public class ConvertResult {

    /**
     * @param code 操作码
     * @param map  操作结果集
     * @return
     */
    public static ResultVO result(int code, Map<String, Object> map) {
        ResultVO model = new ResultVO();
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