package com.lee.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lee
 * @date 2020/1/10 16:00
 */
@Entity
@Table(name = "security_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean status;
}
