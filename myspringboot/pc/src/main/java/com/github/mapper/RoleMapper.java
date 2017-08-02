package com.github.mapper;

import com.github.entity.Role;
import org.apache.ibatis.annotations.Param;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/8/2.
 */
public interface RoleMapper {
    int insert(Role role);
    int update(Role role);
    Role findByRecordId(@Param("recordId")String recordId);
    Role findByCode(@Param("code")String code);
}
