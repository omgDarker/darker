package com.vip.core.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/5/25 11:48 上午
 * @version: v1.0.0
 */
@Data
public class DemoData {
    //设置excel表头名称
    @ExcelProperty(value = "订单号", index = 0)
    private String orderNo;
    @ExcelProperty(value = "产品ID", index = 1)
    private String productId;
    @ExcelProperty(value = "联盟ID", index = 2)
    private String allianceId;
    @ExcelProperty(value = "分成比例", index = 3)
    private String radio;
    @ExcelProperty(value = "分成金额", index = 4)
    private String amountDivided;
}
