package com.lee.springboot.dynamic.module.sys;

//import com.lee.springboot.dynamic.datasource.DataSourceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author lee
 * @date 2019/12/24 10:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void findUser() {
        User user = userService.findUser(1L);
        User user2 = userService.findUser2(1L);

        log.info("user: " + user.toString());
        log.info("user2: " + user2.toString());


        Object firstDataSource = applicationContext.getBean("firstDataSource");
        Object secondDataSource = applicationContext.getBean("secondDataSource");
        Object dataSourceAspect = applicationContext.getBean("dataSourceAspect");
        Object dynamicDataSource = applicationContext.getBean("dynamicDataSource");

        log.info("firstDataSource: " + firstDataSource);
        log.info("secondDataSource: " + secondDataSource);
        log.info("DataSourceAspect: " + dataSourceAspect);
        log.info("dynamicDataSource: " + dynamicDataSource);


        Assert.assertNotNull(user);
        Assert.assertNotNull(user2);

    }

}