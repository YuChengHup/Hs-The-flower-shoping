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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getOrdTotalPrice() {
        return ordTotalPrice;
    }

    public void setOrdTotalPrice(Double ordTotalPrice) {
        this.ordTotalPrice = ordTotalPrice;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdRemark() {
        return ordRemark;
    }

    public void setOrdRemark(String ordRemark) {
        this.ordRemark = ordRemark;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getBySp1() {
        return bySp1;
    }

    public void setBySp1(String bySp1) {
        this.bySp1 = bySp1;
    }

    public String getBySp2() {
        return bySp2;
    }

    public void setBySp2(String bySp2) {
        this.bySp2 = bySp2;
    }

    public Orders() {
    }

    public Orders(Integer ordId, Consumer consumer, Location location, Double ordTotalPrice, String ordStatus, String ordRemark, LocalDateTime gmtCreate, LocalDateTime gmtModified, String bySp1, String bySp2) {
        this.ordId = ordId;
        this.consumer = consumer;
        this.location = location;
        this.ordTotalPrice = ordTotalPrice;
        this.ordStatus = ordStatus;
        this.ordRemark = ordRemark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.bySp1 = bySp1;
        this.bySp2 = bySp2;
    }
}