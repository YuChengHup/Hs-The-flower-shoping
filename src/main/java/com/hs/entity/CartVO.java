package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: 羽程
 * @create: 2021-10-27 15:56
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartVO {
    private static final long serialVersionUID = -50079866455494258L;
    /**
     * 购物车编号
     */
    private Integer carId;
    /**
     * 商品编号
     */
    private Commodity commodity;
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
