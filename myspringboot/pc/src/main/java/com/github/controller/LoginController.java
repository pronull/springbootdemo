package com.github.controller;


import com.github.entity.User;
import com.github.service.UserService;
import com.github.vos.RespVo;
import com.github.vos.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public RespVo<String> login(@RequestBody UserVo userVo) {
        Assert.notNull(userVo, "请求参数不能为空");
        Assert.hasText(userVo.getAccount(), "账户不能为空");
        Assert.hasText(userVo.getPassword(), "密码不能为空");
        User accountAndPassword = userService.findUserByAccountAndPassword(userVo.getAccount(), userVo.getPassword());
        Assert.notNull(accountAndPassword, "账户名或密码错误");
        return RespVo.success("登录成功");
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}