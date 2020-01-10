package org.spring.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        Unsafe unsafe = Unsafe.getUnsafe();
        return "Hello,World!";
    }
}
