package com.vip.darker.enums;

/**
 * @Auther: Darker
 * @Date: 2019/01/28 16:07
 * @Description: 操作状态枚举（1.类型不安全 2.无命名空间）
 */
public enum OperationStatusEnum {

    SUCCESS("success"),
    SUCCESS_INSERT("新增成功!"),
    SUCCESS_UPDATE("更新成功!"),
    SUCCESS_DELETE("删除成功!"),
    SUCCESS_UPLOAD("上传成功!"),
    FAIL("fail"),
    FAIL_INSERT("新增失败!"),
    FAIL_UPDATE("更新失败!"),
    FAIL_DELETE("删除失败!"),
    FAIL_UPLOAD("上传失败!");

    private final String name;

    OperationStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}