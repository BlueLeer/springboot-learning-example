package com.lee.springbootleeamqp.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 21:34
 */
@Component
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, String routerKey) {
        rabbitTemplate.convertAndSend("direct_exchange", routerKey, msg);
    }
}
