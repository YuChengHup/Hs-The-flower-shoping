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
    private Orders orders;
    /**
    * 物流状态
    */
    private String logStatus;
    /**
    * 发货日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime logCreate;
    /**
     * 到货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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