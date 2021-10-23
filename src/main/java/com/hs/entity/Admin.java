package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = -29974046765587878L;
    /**
    * 编号
    */
    private Integer admId;
    /**
    * 管理员
    */
    private String admZh;
    /**
    * 密码
    */
    private String passwd;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;




}