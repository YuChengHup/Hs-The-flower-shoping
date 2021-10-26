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
//    /**
//    * 用户编号
//    */
//    private Integer conId;
    /**
     * 使用实体类
     */
    private Consumer consumer;

//    /**
//    * 地址编号
//    */
//    private Integer locId;
    /**
     * 使用实体类
     */

    private Location location;
    /**
    * 总价
    */
    private Double ordTotalPrice;
    /**
    * 订单状态
    */
    private String ordStatus;
    /**
    * 快递方式
    */
    private String ordRemark;
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