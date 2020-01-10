package com.lee.security.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lee
 * @date 2020/1/10 16:12
 */
@Entity
@Table(name = "security_role_permission")
@Data
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long roleId;
    
    private Long permissionId;
    
    private Boolean status;
}
