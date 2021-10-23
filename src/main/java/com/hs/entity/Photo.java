package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Photo)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo implements Serializable {
    private static final long serialVersionUID = 639108154124251042L;
    /**
    * 图片编号
    */
    private Integer phoId;
    /**
    * 图片路径
    */
    private String phoUrl;
    /**
    * 商品编号
    */
    private Integer comId;
    /**
    * 是否是默认，0否1是
    */
    private Integer phoDefault;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;




}