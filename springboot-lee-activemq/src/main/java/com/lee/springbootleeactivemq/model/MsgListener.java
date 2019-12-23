package com.lee.springbootleeactivemq.model;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author WangLe
 * @date 2018/12/21 15:01
 * @description
 */
@Component
public class MsgListener {
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接收到消息----------" + message);
    }
}
