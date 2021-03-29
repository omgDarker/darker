package com.vip.darker.rocket.producer;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : wangbingan
 * @description: 生产者
 * @date: 2021/3/26 5:27 下午
 * @version: v1.0.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DarkerProducer {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Test
    public void send() throws Exception {
        String msg = "demo msg";
        log.info("消息开始发送msg:{}", msg);
        Message message = new Message("DemoTopic", "DemoTag", msg.getBytes());
        SendResult sendResult = defaultMQProducer.send(message);
        log.info("消息发送完成sendResult:{}", sendResult);
    }

    @Test
    public void sendDelayMsg() throws Exception {
        // 1s、 5s、 10s、 30s、 1m、 2m、 3m、 4m、 5m、 6m、 7m、 8m、 9m、 10m、 20m、 30m、 1h、 2h
        String msg = "demo delay msg";
        log.info("消息开始发送delay msg:{}", msg);
        Message message = new Message("DemoTopic", null, msg.getBytes());
        message.setDelayTimeLevel(4);
        SendResult sendResult = defaultMQProducer.send(message);
        log.info("消息发送完成delay sendResult:{}", sendResult);
        defaultMQProducer.shutdown();
    }
}
