package com.lee.springboot.dynamic.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lee
 * @date 2019/12/23 15:43
 */
@Configuration
public class DynamicDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * "@Primary"注解使得优先选用
     *
     * @param firstDataSource
     * @param secondDataSource
     * @return
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<Object, Object> dataSources = new HashMap<>();
        dataSources.put(DataSourceNames.FIRST.name(), firstDataSource);
        dataSources.put(DataSourceNames.SECOND.name(), secondDataSource);
        return new DynamicDataSource(firstDataSource, dataSources);
    }
}
