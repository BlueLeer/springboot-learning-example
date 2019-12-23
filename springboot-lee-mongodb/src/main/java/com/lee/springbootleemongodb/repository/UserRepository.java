package com.lee.springbootleemongodb.repository;

import com.lee.springbootleemongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author WangLe
 * @date 2018/12/20 10:09
 * @description
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);

    // 用json字符串构造查询参数
    @Query("{'userId': ?0}")
    List<User> findWithUserid(Long userId);

}
