package com.lee.springboot.dynamic.module.sys;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * @author lee
 * @date 2019/12/24 10:06
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    
}
