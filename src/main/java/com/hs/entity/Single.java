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
    private Commodity commodity;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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