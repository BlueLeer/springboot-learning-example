package com.lee.async.controller;

import com.lee.async.model.RegisterResult;
import com.lee.async.service.EmailService;
import com.lee.async.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lee
 * @date 2019/12/25 11:06
 */
@RestController
@Slf4j
public class HelloAsync {
    @Autowired
    private MessageService messageService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/register")
    public RegisterResult register(String username, String email, String mobile) {
        RegisterResult result = new RegisterResult();
        // 执行注册逻辑
        //.....
        // 注册完成以后,发短信和邮件通知
        CompletableFuture<String> sendMsg = messageService.sendMsg(username, mobile);
        CompletableFuture<String> sendEmail = emailService.sendEmail(username, email);

        CompletableFuture.allOf(sendEmail, sendMsg).join();

        try {
            String emailResult = sendEmail.get();
            result.setEmailCode("1");
            result.setEmailResult("邮件发送成功!");
            log.info(emailResult);
        } catch (InterruptedException e) {
            result.setEmailCode("0");
            result.setEmailResult("邮件发送失败!");
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            log.error(e.getMessage());
            result.setEmailCode("0");
            result.setEmailResult("邮件发送出现异常!");
        }

        try {
            String msgResult = sendMsg.get();
            result.setMessageCode("1");
            result.setMessageResult("短信发送成功!");
            log.info(msgResult);
        } catch (InterruptedException e) {
            result.setMessageCode("0");
            result.setMessageResult("短信发送失败!");
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            log.error(e.getMessage());
            result.setMessageCode("0");
            result.setMessageResult("短信发送出现异常!");
        }
        return result;

    }
}
