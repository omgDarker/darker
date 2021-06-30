package com.vip.core.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/5/25 12:05 下午
 * @version: v1.0.0
 */
//继承AnalysisEventListener ，DemoData -对应实体类
public class ExcelListener extends AnalysisEventListener<DemoData> {

    //读取表头
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }
    //一行一行读取数据
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("update pe_order_share_detail set ratio ='" + demoData.getRadio()+"',"
                +"amount_divided=" + demoData.getAmountDivided()
                +" where"
                +" order_no = '" + demoData.getOrderNo()+"'"
                +" and"
                +" product_id = " + demoData.getProductId() +""
                +" and"
                +" alliance_id ='" + demoData.getAllianceId()+"';");
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
