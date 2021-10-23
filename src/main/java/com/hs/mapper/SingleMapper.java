package com.hs.mapper;

import com.hs.entity.Single;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Single)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SingleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param sinId 主键
     * @return 实例对象
     */
    Single queryById(Integer sinId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Single> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param single 实例对象
     * @return 对象列表
     */
    List<Single> queryAll(Single single);

    /**
     * 新增数据
     *
     * @param single 实例对象
     * @return 影响行数
     */
    int insert(Single single);

    /**
     * 修改数据
     *
     * @param single 实例对象
     * @return 影响行数
     */
    int update(Single single);

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 影响行数
     */
    int deleteById(Integer sinId);

}