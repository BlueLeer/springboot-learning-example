package com.lee.springboot.dynamic.module.sys;

import com.lee.springboot.dynamic.datasource.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @date 2019/12/24 15:28
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        User user = userService.findUser(1L);
        User user2 = userService.findUser2(1L);
        users.add(user);
        users.add(user2);

        return users;

    }
}
