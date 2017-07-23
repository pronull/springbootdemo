package com.github.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by qwe on 2017/7/23.
 */
@Data
public class User {
    private String recordId;
    private String name;
    private String userAccount;
    private String userPassword;
    private String email;
    private Date createTime;
}
