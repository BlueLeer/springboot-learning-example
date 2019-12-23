package com.lee.springbootleemongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangLe
 * @date 2018/12/20 10:02
 * @description
 */
@Document // 代表该类是MongoDB的一个文档实体
public class User {
    @Id
    private Long userId;
    private String username;
    private String password;

    @Field("living_history") // 代表此属性在文档中的名称为 living_history
    private List<Address> addresses = new ArrayList<>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
