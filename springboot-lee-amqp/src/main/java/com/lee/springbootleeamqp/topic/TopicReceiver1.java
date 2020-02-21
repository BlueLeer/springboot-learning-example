package com.lee.springbootleeamqp.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 18:11
 */
@Component
public class TopicReceiver1 {
    @RabbitListener(queues = "topic.message")
    public void process(String message) {
        System.out.println("lee-receiver1----------" + message);
    }
}
