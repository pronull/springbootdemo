package com.github.entity;

import lombok.Data;

import java.util.Date;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/8/2.
 */
@Data
public class Role {
    private String recordId;
    private String name;
    private String code;
    private Date createTime;
}
