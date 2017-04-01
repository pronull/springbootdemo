package com.github.vo.resp;

/**
 * Created by qwe on 2017/3/29.
 */
public class Resp<T> {
    private T data;

    private  boolean success = false;

    public  static <H> Resp<H> success(H data){
        Resp<H> resp = new Resp<H>();
        resp.setData(data);
        resp.setSuccess(true);
        return resp;
    }

    public  boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
