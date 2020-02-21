package com.lee.springbootleeamqp;

import com.lee.springbootleeamqp.direct.DirectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lee
 * @date 2020/2/20 21:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DirectRabbitTest {

    @Autowired
    private DirectSender directSender;

    @Test
    public void mulSend() {

        String _delete_routing_key = "delete";
        String _add_routing_key = "add";
        
        directSender.send("我删除了一条消息...",_delete_routing_key);
        directSender.send("我增加了一条消息...",_add_routing_key);

    }
}
