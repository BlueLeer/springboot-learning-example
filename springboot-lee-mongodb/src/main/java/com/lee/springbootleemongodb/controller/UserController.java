package com.lee.springbootleemongodb.controller;

import com.lee.springbootleemongodb.model.Address;
import com.lee.springbootleemongodb.model.User;
import com.lee.springbootleemongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WangLe
 * @date 2018/12/20 10:21
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("wangle");
        user.setPassword("123456");
        Address address1 = new Address("陕西省安康市", new Date(1994, 5, 2), new Date(2013, 9, 1));
        Address address2 = new Address("海南省海口市", new Date(2013, 9, 1), new Date(2017, 6, 1));
        Address address3 = new Address("江西省南昌市", new Date(2017, 6, 1), new Date(2018, 6, 1));

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        user.setAddresses(addresses);


        User save = userService.save(user);

        return save;
    }

    @GetMapping("/getByName")
    @ResponseBody
    public User findByUsername(String username) {
        User user = userService.findByName(username);
        return user;
    }
}
