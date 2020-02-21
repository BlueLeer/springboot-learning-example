package com.lee.springbootleeamqp;

import com.lee.springbootleeamqp.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lee
 * @date 2020/2/20 22:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FanoutRabbitTest {
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void sendMsg() {
        for (int i = 0; i < 10; i++) {
            fanoutSender.send("I am Lee->" + i);
        }
    }
}
