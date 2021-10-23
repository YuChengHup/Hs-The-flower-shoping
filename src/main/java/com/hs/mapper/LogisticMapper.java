package com.hs.mapper;

import com.hs.entity.Logistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Logistic)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface LogisticMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    Logistic queryById(String logId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Logistic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param logistic 实例对象
     * @return 对象列表
     */
    List<Logistic> queryAll(Logistic logistic);

    /**
     * 新增数据
     *
     * @param logistic 实例对象
     * @return 影响行数
     */
    int insert(Logistic logistic);

    /**
     * 修改数据
     *
     * @param logistic 实例对象
     * @return 影响行数
     */
    int update(Logistic logistic);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(String logId);

}