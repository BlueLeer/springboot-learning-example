package com.lee.springbootleeamqp.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lee
 * @date 2020/2/20 17:22
 */
@Configuration
public class SimpleQueueConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue("simple-queue");
    }
}
