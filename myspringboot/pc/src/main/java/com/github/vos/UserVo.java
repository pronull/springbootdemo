package com.github.vos;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by qwe on 2017/7/23.
 */
@Data
public class UserVo implements Serializable {
    private String userId;
    private String userName;
    private String account;
    private String password;
    private String email;
}
