package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Logistic)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistic implements Serializable {
    private static final long serialVersionUID = -32337517947431653L;
    /**
    * 编号，uuid生活曾
    */
    private String logId;
    /**
    * 订单编号
    */
    private Integer ordId;
    /**
    * 物流状态
    */
    private String logStatus;
    /**
    * 发货日期
    */
    private LocalDateTime logCreate;
    /**
    * 预计到货日期
    */
    private LocalDateTime logEstimate;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;




}