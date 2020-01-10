package com.lee.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lee
 * @date 2020/1/10 16:10
 */
@Entity
@Table(name = "security_permission")
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean status;
}
