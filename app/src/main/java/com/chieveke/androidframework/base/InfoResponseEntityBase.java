package com.chieveke.androidframework.base;

import com.chieveke.arms.data.net.ApiResponse;

/**
 * @description: 带data泛型解析消息实体基类
 * @author: keqichun
 * @date: 2017/7/4 18:37
 * @version: V1.0
 */
public class InfoResponseEntityBase<T> implements ApiResponse {

    /**
     * status : 401
     * msg : 参数不足！
     */

    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean isSuccess() {
        return status==200;
    }

    @Override
    public boolean checkReLogin() {
        return false;
    }

    @Override
    public T getData() {
        return data;
    }
}
