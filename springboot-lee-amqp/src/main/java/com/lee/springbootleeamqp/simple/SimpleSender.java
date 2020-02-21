package com.lee.springbootleeamqp.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 17:20
 */
@Component
public class SimpleSender {

    /**
     * 注入springboot为我们自动配置好的RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 默认发送到direct类型的默认交换机（AMQP default）
    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend("simple-queue", msg);
    }

}
