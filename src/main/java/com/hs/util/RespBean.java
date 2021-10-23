package com.hs.util;

public class RespBean<T> {

    /*状态码*/
    private Integer code;
    /*信息*/
    private String message;
    /*数据*/
    private T data;


    public RespBean() {
    }

    public RespBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespBean(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //不返回数据构造方法
    public RespBean(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    //返回数据构造方法
    public RespBean(CodeEnum codeEnum, T data) {
        this(codeEnum);
        this.data = data;
    }

    public static <T> RespBean <T> success(){
        return new RespBean <T>(CodeEnum.SUCCESS);
    }

    public static <T> RespBean <T> success(T data){
        return new RespBean <T>(CodeEnum.SUCCESS,data);
    }

    //参数格式不正确
    public static <T> RespBean <T> badRequest(){
        return new RespBean <T>(CodeEnum.BAD_REQUEST);
    }

    //失败
    public static <T> RespBean <T> faild(){
        return new RespBean <T>(CodeEnum.FAILD);
    }
    //失败
    public static <T> RespBean <T> username_exists(){
        return new RespBean <T>(CodeEnum.USERNAME_EXISTS);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
