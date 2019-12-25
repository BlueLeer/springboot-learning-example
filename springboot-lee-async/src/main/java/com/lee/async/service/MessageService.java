package com.lee.async.service;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 短信发送 服务类接口
 *
 * @author lee
 * @date 2019/12/25 11:12
 */
public interface MessageService {
    /**
     * 发送短信
     * @param username
     * @param mobile
     * @return 短信发送结果 1成功 0失败
     */
    CompletableFuture<String> sendMsg(String username, String mobile);
}
