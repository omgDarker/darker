package com.vip.darker.rocket.producer.bean;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;


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
     * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
     */
    @Value("${spring.rocketmq.producer.groupName}")
    private String groupName;
    @Value("${spring.rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
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
        if (StringUtils.isEmpty(this.groupName)) {
            log.error("producer groupName is blank");
        }
        if (StringUtils.isEmpty(this.namesrvAddr)) {
            log.error("producer nameServerAddr is blank");
        }
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        producer.setMaxMessageSize(this.maxMessageSize);
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
        try {
            producer.start();
            log.info("producer is start groupName:{},namesrvAddr:{}", this.groupName, this.namesrvAddr);
        } catch (MQClientException e) {
            log.error("producer is error {}", e.getMessage(), e);
        }
        return producer;
    }
}
