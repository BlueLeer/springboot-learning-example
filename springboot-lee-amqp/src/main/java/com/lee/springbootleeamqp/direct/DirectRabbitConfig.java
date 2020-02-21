package com.lee.springbootleeamqp.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lee
 * @date 2020/2/20 21:36
 */
@Configuration
public class DirectRabbitConfig {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Queue directQueue1() {
        return new Queue("directQueue1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("directQueue2");
    }

    /**
     * Direct模式下,只有消息的routingKey和绑定时的routingKey一致时,才会将消息传递到相应的queue当中去
     *
     * @param directQueue1
     * @param directExchange
     * @return
     */
    @Bean
    public Binding directExchange1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("delete");
    }


    @Bean
    public Binding directExchange2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("add");
    }

}
