package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Single)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Single implements Serializable {
    private static final long serialVersionUID = 971143442094529320L;
    /**
    * 单个订单编号
    */
    private Integer sinId;
    /**
    * 所属大订单
    */
    private Integer ordId;
    /**
    * 商品
    */
    private Integer comId;
    /**
    * 购买数量
    */
    private Integer sinNum;
    /**
    * 总价格
    */
    private Double sinPrice;
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