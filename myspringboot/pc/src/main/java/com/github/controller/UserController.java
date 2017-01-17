package com.github.controller;

import com.github.entity.User;
import com.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping(value = "/v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/infos")
    @ResponseBody
    public User getUserInfo(){
        return userService.getUserInfo();
    }
}
