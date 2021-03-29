package com.vip.darker.rocket.comsumer.processor;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : wangbingan[www.wangbingan.com]
 * @description: 消费者监听器
 * @date: 2021/3/29 3:18 下午
 * @version: v1.0.0
 */
@Slf4j
@Component
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {

    /**
     * 主题
     */
    private final String TOPIC = "DemoTopic";
    /**
     * 消费次数
     */
    private final int RECONSUME_TIMES = 3;

    /**
     * 消息消费
     *
     * @param msgExtList 消息
     * @param context    消息者消费上下文
     * @return
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgExtList, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgExtList)) {
            log.info("接收到的消息为空,不处理,直接返回!");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt msgExT = msgExtList.get(0);
        log.info("接收到消息msgExT:{}", msgExT);
        if (!TOPIC.equals(msgExT.getTopic())) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        if (RECONSUME_TIMES == msgExT.getReconsumeTimes()) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        log.info("接收到消息msgExTList:{}", msgExtList);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
