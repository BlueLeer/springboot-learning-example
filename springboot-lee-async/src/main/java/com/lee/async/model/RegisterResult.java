package com.lee.async.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 注册结果 模型
 *
 * @author lee
 * @date 2019/12/25 11:06
 */
@Data
public class RegisterResult implements Serializable {
    private String emailCode;
    private String emailResult;
    private String messageCode;
    private String messageResult;

}
