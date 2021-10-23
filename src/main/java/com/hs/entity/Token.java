package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Token)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {
    private static final long serialVersionUID = 863943530371932917L;
    /**
    * token,uuid生成
    */
    private String token;
    /**
    * 用户编号
    */
    private Integer conId;
    /**
    * 是否登录，0否1是
    */
    private Integer isLogin;




}