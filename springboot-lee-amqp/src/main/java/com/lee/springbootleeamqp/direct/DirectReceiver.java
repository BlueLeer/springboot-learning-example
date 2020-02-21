package com.lee.springbootleeamqp.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 21:44
 */
@Component
public class DirectReceiver {
    @RabbitListener(queues = "directQueue1")
    public void process1(String msg) {
        System.out.println("lee--process1-delete--接收到的消息为: {" + msg + "}");
    }


    @RabbitListener(queues = "directQueue2")
    public void process2(String msg) {
        System.out.println("lee--process2-add--接收到的消息为: {" + msg + "}");
    }


}
