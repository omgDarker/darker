package com.vip.darker.rocket.comsumer.bean;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.vip.darker.rocket.comsumer.processor.MQConsumeMsgListenerProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 消费者bean
 * @date: 2021/3/29 2:50 下午
 * @version: v1.0.0
 */
@Slf4j
@SpringBootConfiguration
public class MQConsumerConfiguration {

    @Value("${spring.rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${spring.rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${spring.rocketmq.consumer.topics}")
    private String topics;
    @Value("${spring.rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${spring.rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;
    @Value("${spring.rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int consumeMessageBatchMaxSize;
    @Autowired
    private MQConsumeMsgListenerProcessor mqConsumeMsgListenerProcessor;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() {
        if (StringUtils.isEmpty(this.groupName)) {
            log.error("consumer groupName is blank");
        }
        if (StringUtils.isEmpty(this.namesrvAddr)) {
            log.error("consumer nameServerAddr is blank");
        }
        if (StringUtils.isEmpty(this.topics)) {
            log.error("consumer topics is blank");
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(this.groupName);
        consumer.setNamesrvAddr(this.namesrvAddr);
        consumer.setConsumeThreadMin(this.consumeThreadMin);
        consumer.setConsumeThreadMax(this.consumeThreadMax);
        consumer.setConsumeMessageBatchMaxSize(this.consumeMessageBatchMaxSize);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setMessageListener(mqConsumeMsgListenerProcessor);
        try {
            String[] topicTagsArr = this.topics.split(";");
            for (String topicTags : topicTagsArr) {
                String[] topicTag = topicTags.split("~");
                consumer.subscribe(topicTag[0], topicTag[1]);
            }
            consumer.start();
            log.info("consumer is start groupName:{},topics:{},namesrvAddr:{}", this.groupName, this.topics, this.namesrvAddr);
        } catch (Exception e) {
            log.error("consumer is error:{}", e.getMessage(), e);
        }
        return consumer;
    }
}
