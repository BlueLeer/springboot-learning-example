package com.lee.springboot.dynamic;

import com.lee.springboot.dynamic.datasource.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 这里一定要排除DataSourceAutoConfiguration的自动配置,不然会出现循环引用的问题
 * 排除了jpa的自动配置,就要引入我们自己的关于多数据源的配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class DynamicDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDataApplication.class, args);
    }
}
