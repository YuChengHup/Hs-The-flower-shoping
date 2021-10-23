package com.hs.mapper;

import com.hs.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Commodity)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface CommodityMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param comId 主键
     * @return 实例对象
     */
    Commodity queryById(Integer comId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Commodity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param commodity 实例对象
     * @return 对象列表
     */
    List<Commodity> queryAll(Commodity commodity);

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int insert(Commodity commodity);

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int update(Commodity commodity);

    /**
     * 通过主键删除数据
     *
     * @param comId 主键
     * @return 影响行数
     */
    int deleteById(Integer comId);

}