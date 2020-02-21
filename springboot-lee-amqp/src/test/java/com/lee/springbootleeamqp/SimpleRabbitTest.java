package com.lee.springbootleeamqp;

import com.lee.springbootleeamqp.simple.SimpleSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRabbitTest {

    @Autowired
    private SimpleSender simpleSender;

    @Test
    public void simpleSendTest() {
        for (int i = 0; i < 100; i++) {
            simpleSender.sendMsg("hello" + i);
        }
    }

}

