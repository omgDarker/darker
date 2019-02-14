package com.vip.darker.system.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: Darker
 * @Date: 2018/11/1 15:09
 * @Description: MQ消息队列(Direct模式, Topic模式)
 */
//@Configuration
public class QueueMQConfig {

    /**
     * @description:用户信息队列
     * @auther: WBA
     * @date: 2018/12/11 17:09
     * @param: []
     * @return: org.springframework.amqp.core.Queue
     */
    @Bean(name = "user")
    public Queue queueUser() {
        return new Queue("topic.user");
    }

    /**
     * @description:角色信息队列
     * @auther: WBA
     * @date: 2018/12/11 17:09
     * @param: []
     * @return: org.springframework.amqp.core.Queue
     */
    @Bean(name = "role")
    public Queue queueRole() {
        return new Queue("topic.role");
    }

    /**
     * @description:权限队列
     * @auther: WBA
     * @date: 2018/12/11 17:09
     * @param: []
     * @return: org.springframework.amqp.core.Queue
     */
    @Bean(name = "permission")
    public Queue queuePermission() {
        return new Queue("topic.permission");
    }

    /**
     * @description:交换机
     * @auther: WBA
     * @date: 2018/12/11 17:09
     * @param: []
     * @return: org.springframework.amqp.core.TopicExchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * @description:交换机队列绑定
     * @auther: WBA
     * @date: 2018/12/11 17:09
     * @param: [queue, exchange]
     * @return: org.springframework.amqp.core.Binding
     */
    @Bean
    Binding bindingExchangeUser(@Qualifier(value = "user") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.user");
    }

    /**
     * 交换机队列绑定
     *
     * @param queue    队列
     * @param exchange 交换机
     * @return
     */
    @Bean
    Binding bindingExchangeRole(@Qualifier(value = "role") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.#");
    }
}