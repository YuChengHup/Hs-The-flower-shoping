package com.hs.util;

public enum CodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "ok"),

    FAILD(500, "失败"),
    USRLMT(600, "权限不足"),


    USERORPASSERROR(300, "用户名或密码错误"),


    USERNAME_EXISTS(301, "用户名已存在"),
    /**
     * 参数不齐全或参数错误
     */
    BAD_REQUEST(400,"参数不正确");

    

    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
