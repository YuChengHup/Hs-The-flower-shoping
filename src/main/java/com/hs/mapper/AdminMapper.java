package com.hs.mapper;

import com.hs.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface AdminMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param admId 主键
     * @return 实例对象
     */
    Admin queryById(Integer admId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);


    /**
     * 通过主键删除数据
     *
     * @param admId 主键
     * @return 影响行数
     */
    int deleteById(Integer admId);

}