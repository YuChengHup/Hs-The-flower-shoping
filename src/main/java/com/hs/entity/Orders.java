package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    private static final long serialVersionUID = -35435275434543255L;
    /**
    * 订单编号
    */
    private Integer ordId;
    /**
    * 用户编号
    */
    private Integer conId;
    /**
    * 地址编号
    */
    private Integer locId;
    /**
    * 总价
    */
    private Double ordTotalPrice;
    /**
    * 订单状态
    */
    private String ordStatus;
    /**
    * 备注
    */
    private String ordRemark;
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