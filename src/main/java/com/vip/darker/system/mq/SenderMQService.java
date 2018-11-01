package com.vip.darker.system.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/11/1 15:09
 * @Description: MQ发送方service
 */
@Service(value = SenderMQService.BEAN_NAME)
public class SenderMQService {

    public final static String BEAN_NAME = "senderMQService";

    private final AmqpTemplate template;

    @Autowired
    public SenderMQService(AmqpTemplate template) {
        this.template = template;
    }

    public void send() {
        template.convertAndSend("exchange","user", "darkerMQ!");
    }
}
