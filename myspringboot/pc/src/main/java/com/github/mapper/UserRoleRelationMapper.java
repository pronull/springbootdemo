package com.github.mapper;

import com.github.entity.Role;
import com.github.entity.UserRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/8/2.
 */
public interface UserRoleRelationMapper {
    int insert(UserRoleRelation userRoleRelation);
    int update(UserRoleRelation userRoleRelation);
    List<UserRoleRelation> findByUserRecordId(@Param("userRecordId") String userRecordId);
}
