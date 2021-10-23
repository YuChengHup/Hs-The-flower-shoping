package com.hs.service;

import com.hs.entity.Size;

import java.util.List;

/**
 * (Size)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SizeService {

    /**
     * 通过ID查询单条数据
     *
     * @param sizId 主键
     * @return 实例对象
     */
    Size queryById(Integer sizId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Size> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param size 实例对象
     * @return 实例对象
     */
    Size insert(Size size);

    /**
     * 修改数据
     *
     * @param size 实例对象
     * @return 实例对象
     */
    Size update(Size size);

    /**
     * 通过主键删除数据
     *
     * @param sizId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sizId);

}