package com.lee.async.service;

import java.util.concurrent.CompletableFuture;

/**
 * 邮件发送服务类接口
 *
 * @author lee
 * @date 2019/12/25 11:13
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param username
     * @param emailAddr
     * @return 发送结果 1成功 0失败
     */
    CompletableFuture<String> sendEmail(String username, String emailAddr);
}
