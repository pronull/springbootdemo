package com.github.vos;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by qwe on 2017/7/23.
 */
@Data
public class RespVo<T> implements Serializable {

    private T content;

    private boolean success;

    public static <E> RespVo success(E content) {
        RespVo respVo = new RespVo();
        respVo.setSuccess(true);
        respVo.setContent(content);
        return respVo;
    }

    public static RespVo error() {
        RespVo respVo = new RespVo();
        respVo.setSuccess(false);
        respVo.setContent("error");
        return respVo;
    }
}
