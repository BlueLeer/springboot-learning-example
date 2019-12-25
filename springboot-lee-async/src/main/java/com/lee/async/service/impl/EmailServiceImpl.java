package com.lee.async.service.impl;

import com.lee.async.service.EmailService;
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
public class EmailServiceImpl implements EmailService {
    @Async
    @Override
    public CompletableFuture<String> sendEmail(String username, String emailAddr) {
        String result = "姓名: " + username + ",邮件地址: " + emailAddr + ", 邮件发送成功!";
        log.info("姓名: " + username + ",邮件地址: " + emailAddr);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(result);
    }
}
