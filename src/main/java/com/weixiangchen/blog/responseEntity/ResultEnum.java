package com.weixiangchen.blog.responseEntity;

import lombok.Getter;

@Getter
public enum ResultEnum {
    OK(true, 200, "请求成功"),
    BAD_REQUEST(false, 400, "请求参数错误");

    private Integer code;
    private Boolean success;
    private String message;

    ResultEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
