package com.lee.springbootleeamqp.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lee
 * @date 2020/2/20 17:57
 */
@Configuration
public class TopicRabbitConfig {
    final static String MESSAGE = "topic.message";
    final static String MESSAGES = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(MESSAGE);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(MESSAGES);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * queueMessage同时只能匹配一个队列,也就是queueMessage这个队列
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        // *: 代表一个词
        // #: 代表零个或多个词
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
