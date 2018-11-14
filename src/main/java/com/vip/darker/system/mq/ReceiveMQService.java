package com.vip.darker.system.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/11/1 15:09
 * @Description: MQ接收方Service
 */
@Service(value = ReceiveMQService.BEAN_NAME)
public class ReceiveMQService {

    public final static String BEAN_NAME = "receiveMQService";

//    @RabbitListener(queues = "user") //监听器监听指定的Queue
    public void receiveUser(Object obj) {
        System.out.println(obj);
    }

//    @RabbitListener(queues = "role")
    public void receiveRole(Object obj) {
        System.out.println(obj);
    }

//    @RabbitListener(queues = "permission")
    public void receivePermission(Object obj) {
        System.out.println(obj);
    }
}
