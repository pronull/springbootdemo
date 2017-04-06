package com.github.controller;

import com.github.entity.User;
import com.github.service.UserService;
import com.github.vo.resp.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by qwe on 2017/3/29.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("v1/user/find/{account}")
    @ResponseBody
    public Resp<User> findUserByAccount(@PathVariable("account") String userAccount) {
        return Resp.success(userService.findUserByAccount(userAccount));
    }
}
