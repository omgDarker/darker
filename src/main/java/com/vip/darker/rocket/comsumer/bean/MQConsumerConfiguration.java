package com.vip.darker.rocket.comsumer.bean;

import com.vip.darker.rocket.comsumer.processor.MQConsumeMsgListenerProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 消费者bean
 * @date: 2021/3/29 2:50 下午
 * @version: v1.0.0
 */
@Slf4j
@SpringBootConfiguration
public class MQConsumerConfiguration {

    /**
     * 服务注册地址
     */
    @Value("${spring.rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    /**
     * 分组
     */
    @Value("${spring.rocketmq.consumer.groupName}")
    private String groupName;
    /**
     * topics
     */
    @Value("${spring.rocketmq.consumer.topics}")
    private String topics;
    /**
     * 消费最小线程数
     */
    @Value("${spring.rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    /**
     * 消费最大线程数
     */
    @Value("${spring.rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;
    /**
     * 批量消费大小（例如消息集合大小为3,如采用默认值1,那么需要将消息集合拆成3个,用线程去执行）
     */
    @Value("${spring.rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int consumeMessageBatchMaxSize;
    @Autowired
    private MQConsumeMsgListenerProcessor mqConsumeMsgListenerProcessor;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(this.groupName);
        try {
            consumer.setNamesrvAddr(this.namesrvAddr);
            consumer.setConsumeThreadMin(this.consumeThreadMin);
            consumer.setConsumeThreadMax(this.consumeThreadMax);
            consumer.setConsumeMessageBatchMaxSize(this.consumeMessageBatchMaxSize);
            consumer.setMessageListener(mqConsumeMsgListenerProcessor);
            consumer.subscribe(this.topics, "");
            consumer.start();
            log.info("consumer is start namesrvAddr:{},groupName:{},topics:{}", this.namesrvAddr, this.groupName, this.topics);
        } catch (Exception e) {
            log.error("consumer is error:{}", e.getMessage(), e);
        }
        return consumer;
    }
}
