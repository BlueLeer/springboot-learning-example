package com.lee.springbootleeamqp.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 18:13
 */
@Component
public class TopicReceiver2 {
    @RabbitListener(queues = "topic.messages")
    public void process(String message) {
        System.out.println("lee-receiver2----------" + message);
    }
}
