package com.lee.springbootleeactivemq.model;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author WangLe
 * @date 2018/12/21 14:53
 * @description 定义JMS发送的消息需要实现MessageCreator接口
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("Hello----------" + System.currentTimeMillis());
    }
}
