package com.lee.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author lee
 * @date 2019/12/25 11:16
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 执行异步任务所要用到的线程池,如果不配置这个线程池,Spring会自动创建SimpleAsyncTaskExecutor,并使用它来执行异步任务
     * @return
     */
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("lee线程池-");
        executor.initialize();
        return executor;
    }

}
