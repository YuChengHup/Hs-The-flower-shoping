package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Location)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
    private static final long serialVersionUID = 433289416237192486L;
    /**
    * 地址编号
    */
    private Integer locId;
    /**
    * 具体地址
    */
    private String locAddress;
    /**
    * 收件人
    */
    private String locName;
    /**
    * 电话
    */
    private String locTel;
    /**
    * 用户编号
    */
    private Integer conId;
    /**
    * 是否是默认地址，0否1是
    */
    private Integer locDefault;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;




}