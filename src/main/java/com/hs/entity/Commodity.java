package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Commodity)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity implements Serializable {
    private static final long serialVersionUID = 841668848273355742L;
    /**
    * 商品编号
    */
    private Integer comId;
    /**
    * 商品名
    */
    private String comName;
    /**
    * 进价
    */
    private Double comPurchPrice;
    /**
    * 售价
    */
    private Double comPrice;
    /**
    * 库存
    */
    private Integer comNum;
    /**
    * 描述
    */
    private String comDescription;
    /**
    * 销量
    */
    private Integer comVolume;
    /**
    * 种类
    */
    private Integer sorId;
    /**
    * 插入时间
    */
    private LocalDateTime gmtCreate;
    /**
    * 修改时间
    */
    private LocalDateTime gmtModified;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;




}