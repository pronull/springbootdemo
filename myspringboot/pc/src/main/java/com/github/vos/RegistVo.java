package com.github.vos;

import lombok.Data;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/8/2.
 */
@Data
public class RegistVo {
    private String userName;
    private String account;
    private String password;
    private String email;

}
