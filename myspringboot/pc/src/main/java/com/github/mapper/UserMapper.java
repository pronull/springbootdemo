package com.github.mapper;

import com.github.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qwe on 2017/7/23.
 */
public interface UserMapper {
    int insert(User user);

    int update(User user);


    User findUserByAccount(@Param("userAccount") String userAccount);

    User findUserByAccountAndPassword(@Param("account")String account,@Param("password") String password);
}
