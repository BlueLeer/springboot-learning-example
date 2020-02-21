package com.lee.springbootleeamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lee
 * @date 2020/2/20 18:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicRabbitTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void mulSend() {
        // 该条消息,经由交换机以后,会转发到 queueMessage 和 queueMessages这两个队列中
        rabbitTemplate.convertAndSend("exchange", "topic.message", "message1");
        // 该条消息,精油交换机以后,会转发到 queueMessage 这个队列中
        rabbitTemplate.convertAndSend("exchange", "topic.messages", "message2");

        // 也就是说,最终结果是,Receiver1收到了1条消息,而Receiver2收到了2条消息
        // 测试结果如下:
        /*
        lee-receiver2----------message1
        lee-receiver2----------message2
        lee-receiver1----------message1
         */
        
    }

}

