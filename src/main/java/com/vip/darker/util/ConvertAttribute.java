package com.vip.darker.util;

import com.vip.darker.entity.ColumnDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/11/16 14:07
 * @Description: 属性值转换工具类 初始化由SpringBootApplicationListener监听器填充数据
 */
public class ConvertAttribute {
    // 栏目
    private static Map<Integer, String> columnMap = new HashMap<>();
    // 分类
    private static Map<Integer, String> classifyMap = new HashMap<>();
    // 栏目列表
    private static List<ColumnDO> columnList = new ArrayList<>();

    public static Map<Integer, String> getColumnMap() {
        return columnMap;
    }

    public static void setColumnMap(Map<Integer, String> columnMap) {
        ConvertAttribute.columnMap = columnMap;
    }

    public static Map<Integer, String> getClassifyMap() {
        return classifyMap;
    }

    public static void setClassifyMap(Map<Integer, String> classifyMap) {
        ConvertAttribute.classifyMap = classifyMap;
    }

    public static List<ColumnDO> getColumnList() {
        return columnList;
    }

    public static void setColumnList(List<ColumnDO> columnList) {
        ConvertAttribute.columnList = columnList;
    }
}