package com.vip.core.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description:
 * @date: 2021/5/25 12:06 下午
 * @version: v1.0.0
 */
public class TestEasyExcelRead {

    /**
     * 从excel读取数据，然后拼接字符串
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        //实现excel读的操作
        String filename = "/Users/koolearn/Desktop/ad2.xlsx";
        EasyExcel.read(filename, DemoData.class, new ExcelListener()).sheet().doRead();

    }
}
