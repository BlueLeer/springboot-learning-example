package com.lee.springboot.dynamic.module.sys;

import com.lee.springboot.dynamic.datasource.DataSourceNames;
import com.lee.springboot.dynamic.datasource.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @date 2019/12/24 10:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @DataSource(name = "first")
    public User findUser(Long id) {
        return userDao.selectById(id);
    }

    @Override
    @DataSource(name = "second")
    public User findUser2(Long id) {
        return userDao.selectById(id);
    }

}
