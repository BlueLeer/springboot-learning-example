package com.lee.springbootleeamqp.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/2/20 22:15
 */
@Component
public class FanoutReceiver {
    @RabbitListener(queues = "fanoutQueue1")
    public void process1(String msg) {
        System.out.println("lee-fanout-process1--{" + msg + "}");
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void process2(String msg) {
        System.out.println("lee-fanout-process2--{" + msg + "}");
    }
}
