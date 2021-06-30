package com.vip.core.excel;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/5/25 11:48 上午
 * @version: v1.0.0
 */
@Slf4j
public class TestEasyExcelWrite {

    public static void main(String[] args) {

        //实现excel写的操作
        //1 设置写入文件夹地址和excel文件名称
        String filename = "/Users/koolearn/Desktop/ad.xlsx";
        // 2 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename, DemoData.class).sheet("Sheet1").doWrite(getData());

    }

    //创建方法返回list集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setOrderNo(i + "");
            data.setProductId("lucy" + i);
            list.add(data);
        }
        log.info("excel content:{}", list);
        return list;
    }
}
