package com.github.service;

import com.github.entity.User;
import com.github.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 17/1/17.
 */
@Service
@Slf4j
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByUserName(String userName) {
        return userMapper.findUserByAccount(userName);
    }

    @Transactional
    public void save(User newUser) {
        newUser.setRecordId(UUID.randomUUID().toString());
        newUser.setCreateTime(new Date());
        log.info("新增用户{}", newUser);
        userMapper.insert(newUser);
    }

    public User findUserByAccountAndPassword(String account,String password) {
        return userMapper.findUserByAccountAndPassword(account,password);
    }
}
