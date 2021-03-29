package com.vip.darker.rocket.exception;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: MQ异常枚举类
 * @date: 2021/3/26 6:03 下午
 * @version: v1.0.0
 */
public enum RocketMQErrorEnum {

    /********公共********/
    PARAMM_NULL("MQ_001", "参数为空"),

    /********生产者*******/

    /********消费者*******/
    NOT_FOUND_CONSUMESERVICE("MQ_100", "根据topic和tag没有找到对应的消费服务"),

    HANDLE_RESULT_NULL("MQ_101", "消费方法返回值为空"),

    CONSUME_FAIL("MQ_102", "消费失败");
    /**
     * 编码
     */
    private final String code;
    /**
     * 消息内容
     */
    private final String msg;

    RocketMQErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
