package com.hs.entity;

import java.io.Serializable;

/**
 * (Star)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public class Star implements Serializable {
    private static final long serialVersionUID = 705211284983348983L;
    /**
    * 收藏编号
    */
    private Integer staId;
    /**
    * 收藏用户
    */
    private Integer conId;
    /**
    * 收藏商品
    */
    private Integer comId;
    /**
    * 备用
    */
    private String bySp1;
    /**
    * 备用
    */
    private String bySp2;


    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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