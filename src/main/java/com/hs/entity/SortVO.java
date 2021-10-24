package com.hs.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sort类的扩展类
 */

public class SortVO {

    private static final long serialVersionUID = 957268691061285548L;
    /**
     * 类型编号
     */
    private Integer sorId;
    /**
     * 类型名字
     */
    private String sorName;
    /**
     * 分类实体类
     */
    private Size size;

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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public SortVO(Integer sorId, String sorName, Size size) {
        this.sorId = sorId;
        this.sorName = sorName;
        this.size = size;
    }

    public SortVO() {
    }
}
