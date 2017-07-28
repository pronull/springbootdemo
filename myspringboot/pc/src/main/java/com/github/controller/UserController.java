package com.github.controller;

import com.github.vos.RespVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/7/28.
 */
@CrossOrigin
@RestController
@RequestMapping("user")
@Api("用户接口")
public class UserController {


    @GetMapping("/index")
    public RespVo<String> getIndex(){

        return RespVo.success("index");
    }
}
