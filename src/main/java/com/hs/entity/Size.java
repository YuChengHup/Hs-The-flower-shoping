package com.hs.entity;

import java.io.Serializable;

/**
 * (Size)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public class Size implements Serializable {
    private static final long serialVersionUID = 755749290479530658L;
    /**
    * 尺寸编号
    */
    private Integer sizId;
    /**
    * 尺寸名
    */
    private String sizName;


    public Integer getSizId() {
        return sizId;
    }

    public void setSizId(Integer sizId) {
        this.sizId = sizId;
    }

    public String getSizName() {
        return sizName;
    }

    public void setSizName(String sizName) {
        this.sizName = sizName;
    }

}