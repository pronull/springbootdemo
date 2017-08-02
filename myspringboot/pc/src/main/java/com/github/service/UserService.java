package com.github.service;

import com.github.entity.Role;
import com.github.entity.User;
import com.github.entity.UserRoleRelation;
import com.github.mapper.RoleMapper;
import com.github.mapper.UserMapper;
import com.github.mapper.UserRoleRelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    public User findUserByUserName(String userName) {
        return userMapper.findUserByAccount(userName);
    }

    @Transactional
    public void save(User newUser) {
        newUser.setRecordId(UUID.randomUUID().toString());
        newUser.setCreateTime(new Date());
        log.info("新增用户{}", newUser);
        encodePassword(newUser);
        int count = userMapper.insert(newUser);
        Assert.isTrue(count>0,"注册失败");

        UserRoleRelation roleRelation = new UserRoleRelation();
        roleRelation.setUserRecordId(newUser.getRecordId());
        //注册用户拥有用户权限
        Role role =  roleMapper.findByCode("ROLE_USER");
        roleRelation.setRoleRecordId(role.getRecordId());
        count = userRoleRelationMapper.insert(roleRelation);
        Assert.isTrue(count>0,"注册失败");

    }

    private void encodePassword(User newUser) {
        newUser.setUserPassword(new BCryptPasswordEncoder().encode(newUser.getUserPassword()));
    }

    public User findUserByAccountAndPassword(String account, String password) {
        return userMapper.findUserByAccountAndPassword(account, password);
    }
}
