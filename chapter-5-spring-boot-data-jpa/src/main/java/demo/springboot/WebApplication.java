package demo.springboot;

import demo.springboot.repository.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by bysocket on 30/09/2017.
 */
@SpringBootApplication
// 使用我们自定义的RepositoryFactoryBean(要使用我们自定义的Repository,必须在这里显示的声明RepositoryFactoryBean)
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
