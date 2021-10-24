package com.hs.mapper;

import com.hs.entity.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Size)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SizeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param sizId 主键
     * @return 实例对象
     */
    Size queryById(Integer sizId);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<Size> queryAll();



}