package com.hs.mapper;

import com.hs.entity.Star;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Star)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface StarMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param staId 主键
     * @return 实例对象
     */
    Star queryById(Integer staId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Star> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param star 实例对象
     * @return 对象列表
     */
    List<Star> queryAll(Star star);

    /**
     * 新增数据
     *
     * @param star 实例对象
     * @return 影响行数
     */
    int insert(Star star);

    /**
     * 修改数据
     *
     * @param star 实例对象
     * @return 影响行数
     */
    int update(Star star);

    /**
     * 通过主键删除数据
     *
     * @param staId 主键
     * @return 影响行数
     */
    int deleteById(Integer staId);

}