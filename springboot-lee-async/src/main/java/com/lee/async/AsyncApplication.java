package com.lee.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring 中异步方法的简单使用
 *
 * @author lee
 * @date 2019/12/25 11:05
 */
@SpringBootApplication
@EnableAsync
public class AsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }
}
