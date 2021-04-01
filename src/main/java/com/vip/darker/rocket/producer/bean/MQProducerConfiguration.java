package com.vip.darker.rocket.producer.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 生产者bean
 * @date: 2021/3/26 5:57 下午
 * @version: v1.0.0
 */
@Slf4j
@SpringBootConfiguration
public class MQProducerConfiguration {

    /**
     * 服务注册地址
     */
    @Value("${spring.rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    /**
     * 分组
     */
    @Value("${spring.rocketmq.producer.groupName}")
    private String groupName;
    /**
     * 消息最大大小，默认4M
     */
    @Value("${spring.rocketmq.producer.maxMessageSize}")
    private Integer maxMessageSize;
    /**
     * 消息发送超时时间，默认3秒
     */
    @Value("${spring.rocketmq.producer.sendMsgTimeout}")
    private Integer sendMsgTimeout;
    /**
     * 消息发送失败重试次数，默认2次
     */
    @Value("${spring.rocketmq.producer.retryTimesWhenSendFailed}")
    private Integer retryTimesWhenSendFailed;

    @Bean
    public DefaultMQProducer getRocketMQProducer() {
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        try {
            producer.setNamesrvAddr(this.namesrvAddr);
            producer.setMaxMessageSize(this.maxMessageSize);
            producer.setSendMsgTimeout(this.sendMsgTimeout);
            producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
            producer.start();
            log.info("producer is start namesrvAddr:{},groupName:{}", this.namesrvAddr, this.groupName);
        } catch (MQClientException e) {
            log.error("producer is error {}", e.getMessage(), e);
        }
        return producer;
    }
}
