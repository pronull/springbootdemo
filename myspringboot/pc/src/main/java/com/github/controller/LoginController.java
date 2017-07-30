package com.github.controller;


import com.github.entity.User;
import com.github.service.UserService;
import com.github.vos.RespVo;
import com.github.vos.UserVo;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.Assert;

import org.springframework.web.bind.annotation.*;

/**
 * Created by qwe on 2017/7/16.
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RespVo<UserVo> login(UserVo userVo) {
        Assert.notNull(userVo, "请求参数不能为空");
        Assert.hasText(userVo.getUsername(), "账户不能为空");
        Assert.hasText(userVo.getPassword(), "密码不能为空");
        User user = userService.findUserByAccountAndPassword(userVo.getUsername(),userVo.getPassword());
        Assert.notNull(user, "账户名或密码错误");
        UserVo resp = new UserVo();
        resp.setUsername(user.getName());
        return RespVo.success(resp);
    }

    @RequestMapping("/login-error")
    public String loginError() {
        return "login";
    }

}