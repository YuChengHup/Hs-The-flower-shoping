package com.hs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
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
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConNum() {
        return conNum;
    }

    public void setConNum(Integer conNum) {
        this.conNum = conNum;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
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

}