package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtCreate;
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