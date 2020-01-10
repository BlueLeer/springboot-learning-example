package com.lee.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lee
 * @date 2020/1/10 16:11
 */
@Entity
@Table(name = "security_user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    private Long roleId;
    
    private Boolean status;
}
