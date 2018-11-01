package com.vip.darker.runner;

import com.vip.darker.DarkerApplication;
import com.vip.darker.system.mq.SenderMQService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Darker
 * @Date: 2018/11/1 15:09
 * @Description: MQ测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DarkerApplication.class)
public class RabbitMQRunner {

    @Autowired
    protected SenderMQService senderMQService;

    @Test
    public void send(){
        senderMQService.send();
    }
}
