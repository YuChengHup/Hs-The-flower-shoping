package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class CommodityVO {

    private static final long serialVersionUID = 841668848273355743L;
    /**
     * 商品编号
     */
    private Integer comId;
    /**
     * 商品名
     */
    private String comName;
    /**
     * 进价
     */
    private Double comPurchPrice;
    /**
     * 售价
     */
    private Double comPrice;
    /**
     * 库存
     */
    private Integer comNum;
    /**
     * 描述
     */
    private String comDescription;
    /**
     * 销量
     */
    private Integer comVolume;
    /**
     * 种类
     */
    private SortVO sortVO;
    /**
     * 插入时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
    /**
     * 备用
     */
    private String bySp1;
    /**
     * 备用
     */
    private String bySp2;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Double getComPurchPrice() {
        return comPurchPrice;
    }

    public void setComPurchPrice(Double comPurchPrice) {
        this.comPurchPrice = comPurchPrice;
    }

    public Double getComPrice() {
        return comPrice;
    }

    public void setComPrice(Double comPrice) {
        this.comPrice = comPrice;
    }

    public Integer getComNum() {
        return comNum;
    }

    public void setComNum(Integer comNum) {
        this.comNum = comNum;
    }

    public String getComDescription() {
        return comDescription;
    }

    public void setComDescription(String comDescription) {
        this.comDescription = comDescription;
    }

    public Integer getComVolume() {
        return comVolume;
    }

    public void setComVolume(Integer comVolume) {
        this.comVolume = comVolume;
    }

    public SortVO getSortVO() {
        return sortVO;
    }

    public void setSortVO(SortVO sortVO) {
        this.sortVO = sortVO;
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

    public CommodityVO() {
    }

    public CommodityVO(Integer comId, String comName, Double comPurchPrice, Double comPrice, Integer comNum, String comDescription, Integer comVolume, SortVO sortVO, LocalDateTime gmtCreate, LocalDateTime gmtModified, String bySp1, String bySp2) {
        this.comId = comId;
        this.comName = comName;
        this.comPurchPrice = comPurchPrice;
        this.comPrice = comPrice;
        this.comNum = comNum;
        this.comDescription = comDescription;
        this.comVolume = comVolume;
        this.sortVO = sortVO;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.bySp1 = bySp1;
        this.bySp2 = bySp2;
    }
}
