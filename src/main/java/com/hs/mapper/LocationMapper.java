package com.hs.mapper;

import com.hs.entity.Location;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Location)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface LocationMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param locId 主键
     * @return 实例对象
     */
    Location queryById(Integer locId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param location 实例对象
     * @return 对象列表
     */
    List<Location> queryAll(Location location);

    /**
     * 新增数据
     *
     * @param location 实例对象
     * @return 影响行数
     */
    int insert(Location location);

    /**
     * 修改数据
     *
     * @param location 实例对象
     * @return 影响行数
     */
    int update(Location location);

    /**
     * 通过主键删除数据
     *
     * @param locId 主键
     * @return 影响行数
     */
    int deleteById(Integer locId);

}