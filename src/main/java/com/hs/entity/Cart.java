package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart implements Serializable {
    private static final long serialVersionUID = -50079866455494258L;
    /**
    * 购物车编号
    */
    private Integer carId;
    /**
    * 商品编号
    */
    private Integer comId;
    /**
    * 用户编号
    */
    private Integer conId;
    /**
    * 数量
    */
    private Integer conNum;
    /**
    * 插入时间
    */
    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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