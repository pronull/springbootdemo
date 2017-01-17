package com.github.service;

import com.github.entity.User;
import com.github.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 17/1/17.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User getUserInfo(){
        User  user = new User();
        user.setUserAccount("admin");
        return userMapper.selectUserInfo(user);
    }
}
