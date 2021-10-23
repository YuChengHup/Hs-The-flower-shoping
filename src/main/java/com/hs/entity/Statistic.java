package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Statistic)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic implements Serializable {
    private static final long serialVersionUID = 874040599853137476L;
    /**
    * 统计编号
    */
    private Integer staId;
    /**
    * 统计日期
    */
    private LocalDateTime staDate;
    /**
    * 统计商品
    */
    private Integer comId;
    /**
    * 销售额
    */
    private Integer staNum;
    /**
    * 总进价
    */
    private Double staPurchPrice;
    /**
    * 总售价
    */
    private Double staPrice;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;


}