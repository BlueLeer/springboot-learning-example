package com.lee.springbootleeamqp.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author WangLe
 * @date 2018/12/24 10:18
 * @description
 */
@Component
public class SimpleReceiver2 {

    /**
     * 使用 @RabbitListener 来监听RabbitMQ的目的地发送的消息,通过queues属性指定要监听的目的地
     */
    @RabbitListener(queues = "simple-queue")
    public void receiveMessage(String msg) {
        System.out.println("lee-receiver2----------收到消息{" + msg + "}" + System.currentTimeMillis());
    }
}



