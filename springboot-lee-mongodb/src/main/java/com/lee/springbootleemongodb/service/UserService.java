package com.lee.springbootleemongodb.service;

import com.lee.springbootleemongodb.model.User;

/**
 * @author WangLe
 * @date 2018/12/20 10:14
 * @description
 */
public interface UserService {
    User findByName(String username);

    User save(User user);
}
