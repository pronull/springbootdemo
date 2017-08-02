package com.github.controller;

import com.github.entity.User;
import com.github.service.UserService;
import com.github.vos.RegistVo;
import com.github.vos.RespVo;
import com.github.vos.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import static com.github.vos.RespVo.success;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 17/1/17.
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@Api("注册接口")
public class RegistController {

    @Autowired
    private UserService userService;

    @ApiOperation("注册")
    @PostMapping("/sign/up")
    public RespVo<String> signUp(@RequestBody RegistVo userVo) {
        //已存在的不能再注册
        Assert.notNull(userVo, "请求参数不能为空");
        Assert.hasText(userVo.getUserName(), "用户名不能为空");
        Assert.hasText(userVo.getAccount(), "账户不能为空");
        Assert.hasText(userVo.getPassword(), "密码不能为空");
        User user = userService.findUserByUserName(userVo.getUserName());
        Assert.isNull(user, "该账户已被注册");
        User newUser = new User();
        convert(userVo, newUser);
        userService.save(newUser);
        return success("注册成功");
    }

    private void convert(RegistVo vo, User entity) {
        entity.setName(vo.getUserName());
        entity.setUserPassword(vo.getPassword());
        entity.setEmail(vo.getEmail());
        entity.setUserAccount(vo.getAccount());
    }
}
