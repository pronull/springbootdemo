package com.github.service;

/**
 * Created by qwe on 2017/3/29.
 */

import com.github.entity.User;
import com.github.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user")
    public User findUserByAccount(String userAccount) {
        return userMapper.findUserByUserAccount(userAccount);
    }
}
