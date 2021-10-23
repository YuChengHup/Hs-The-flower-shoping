package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * (Consumer)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumer implements Serializable {
    private static final long serialVersionUID = -63273240108979174L;
    /**
    * 用户id
    */
    private Integer conId;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String passwd;
    /**
    * 用户姓名
    */
    private String conName;
    /**
    * 性别
    */
    private String conSex;
    /**
    * 电话
    */
    private String conTel;
    /**
    * 邮箱
    */
    private String conEmail;
    /**
    * 头像
    */
    private String conPhoto;
    /**
    * 帐号状态 ，是否冻结，0否
    */
    private Integer conStatus;
    /**
    * 插入时间
    */
    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtCreate;
    /**
    * 修改时间
    */
    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtModified;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;


}