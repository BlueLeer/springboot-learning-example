package com.lee.springbootleeactivemq.service.impl;

import com.lee.springbootleeactivemq.model.Msg;
import com.lee.springbootleeactivemq.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author WangLe
 * @date 2018/12/21 14:57
 * @description
 */
@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage() {
        // 发送消息
        // 定义了一个消息的目的地:my-destination
        jmsTemplate.send("my-destination", new Msg());
    }
}
