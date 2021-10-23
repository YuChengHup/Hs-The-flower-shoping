package com.hs.entity;

import java.io.Serializable;

/**
 * (Sort)实体类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public class Sort implements Serializable {
    private static final long serialVersionUID = 957268691061285547L;
    /**
    * 类型编号
    */
    private Integer sorId;
    /**
    * 类型名字
    */
    private String sorName;
    /**
    * 尺寸编号
    */
    private Integer sizId;


    public Integer getSorId() {
        return sorId;
    }

    public void setSorId(Integer sorId) {
        this.sorId = sorId;
    }

    public String getSorName() {
        return sorName;
    }

    public void setSorName(String sorName) {
        this.sorName = sorName;
    }

    public Integer getSizId() {
        return sizId;
    }

    public void setSizId(Integer sizId) {
        this.sizId = sizId;
    }

}