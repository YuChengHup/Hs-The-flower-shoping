package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Photo)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo implements Serializable {
    private static final long serialVersionUID = 639108154124251042L;
    /**
    * 图片编号
    */
    private Integer phoId;
    /**
    * 图片路径
    */
    private String phoUrl;
    /**
    * 商品编号
    */
    private Integer comId;
    /**
    * 是否是默认，0否1是
    */
    private Integer phoDefault;
    /**
    * 备用
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bySp1;
    /**
    * 备用
    */
    private String bySp2;




}