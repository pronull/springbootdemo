package com.github.mapper;

import com.github.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 17/1/17.
 */
public interface UserMapper {
    int insert(@Param("user") User user);
    int update(@Param("user") User user);
    int delete(@Param("user") User  user);
    User selectUserInfo(@Param("user") User user);
}
