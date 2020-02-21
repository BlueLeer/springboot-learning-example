package demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by bysocket on 26/09/2017.
 */
@SpringBootApplication
public class QuickStartApplication {
    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(QuickStartApplication.class, args);
    }
}
