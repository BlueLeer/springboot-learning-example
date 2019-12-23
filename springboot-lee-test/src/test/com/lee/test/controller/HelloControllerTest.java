package com.lee.test.controller;

import com.lee.test.SpringBootApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


/**
 * 对于版本比较高的测试 可以直接使用SpringRunner
 */
@SpringBootTest(classes = SpringBootApplicationTest.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebMvc
public class HelloControllerTest {
//    @LocalServerPort
//    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloTest() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + "8080" + "/hello", String.class);
        System.out.println(forEntity.getBody());
    }
}
