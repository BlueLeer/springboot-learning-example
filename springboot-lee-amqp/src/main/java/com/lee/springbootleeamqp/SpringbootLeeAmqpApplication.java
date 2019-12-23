package com.lee.springbootleeamqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootLeeAmqpApplication implements CommandLineRunner {

    /**
     * 注入springboot为我们自动配置好的RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLeeAmqpApplication.class, args);
    }

    /**
     * 定义目的地即队列,队列名称为 my-queue
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("my-queue");
    }


    /**
     * 向队列 my-queue 发送消息
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候!");
    }
}

