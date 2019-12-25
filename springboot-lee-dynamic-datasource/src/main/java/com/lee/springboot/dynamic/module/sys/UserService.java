package com.lee.springboot.dynamic.module.sys;

/**
 * @author lee
 * @date 2019/12/24 10:12
 */
public interface UserService {
    /**
     * 从第一个数据库查询 DataSource: first
     * @param id
     * @return
     */
    User findUser(Long id);

    /**
     * 从第二个数据库查询 DataSource: second
     * @param id
     * @return
     */
    User findUser2(Long id);
}
