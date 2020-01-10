package com.lee.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lee
 * @date 2020/1/10 16:09
 */
@Entity
@Table(name = "security_role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private Boolean status;
}
