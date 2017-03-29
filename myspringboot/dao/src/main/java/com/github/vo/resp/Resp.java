package com.github.vo.resp;

/**
 * Created by qwe on 2017/3/29.
 */
public class Resp<T> {
    private T data;

    private static  boolean success = false;

    public  static <H> Resp<H> success(H data){
        Resp<H> resp = new Resp<H>();
        resp.setData(data);
        resp.setSuccess(true);
        return resp;
    }

    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        Resp.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
