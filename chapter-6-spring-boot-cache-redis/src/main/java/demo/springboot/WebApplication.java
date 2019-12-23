package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 30/09/2017.
 */
@SpringBootApplication
// 开启缓存功能,这个注解会被Spring发现,并且会创建一个切面(aspect),并触发Spring缓存注解的切点(pointcut)
// 根据所使用的注解以及缓存的状态,这个切面会从缓存中获取数据、将数据添加到缓存之中、从缓存中移除某一个值
@EnableCaching
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
