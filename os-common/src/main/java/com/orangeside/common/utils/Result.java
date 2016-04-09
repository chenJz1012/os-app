package com.orangeside.common.utils;

/**
 * Created by cgj on 2015/12/22.
 */
public class Result<T> {
    public Result() {
    }

    public Result(boolean suceess, String message) {
        this.success = suceess;
        this.message = message;
    }

    public Result(boolean suceess, int code, String message) {
        this.code = code;
        this.success = suceess;
        this.message = message;
    }

    public Result(boolean suceess, String message, T data) {
        this.success = suceess;
        this.message = message;
        this.data = data;
    }

    public Result(boolean suceess, int code, String message, T data) {
        this.code = code;
        this.success = suceess;
        this.message = message;
        this.data = data;
    }

    private boolean success;
    private int code = 0;
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
