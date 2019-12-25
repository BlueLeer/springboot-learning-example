package com.lee.async.service.impl;

import com.lee.async.service.MessageService;
import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @date 2019/12/25 11:13
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Async
    @Override
    public CompletableFuture<String> sendMsg(String username, String mobile) {
        log.info("姓名: " + username + ",电话号码: " + mobile);
        String result = "姓名: " + username + ",电话号码: " + mobile + ", 短信发送成功!";
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(result);
    }
}
