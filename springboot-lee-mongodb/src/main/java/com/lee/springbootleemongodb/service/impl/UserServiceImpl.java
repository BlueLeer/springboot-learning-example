package com.lee.springbootleemongodb.service.impl;

import com.lee.springbootleemongodb.model.User;
import com.lee.springbootleemongodb.repository.UserRepository;
import com.lee.springbootleemongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author WangLe
 * @date 2018/12/20 10:14
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        User save = userRepository.save(user);
        Optional<User> byId = userRepository.findById(123L);
        return save;
    }
}
