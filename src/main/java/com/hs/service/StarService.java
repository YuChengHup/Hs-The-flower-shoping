package com.hs.service;

import com.hs.entity.Star;

import java.util.List;

/**
 * (Star)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface StarService {

    /**
     * 通过ID查询单条数据
     *
     * @param staId 主键
     * @return 实例对象
     */
    Star queryById(Integer staId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Star> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param star 实例对象
     * @return 实例对象
     */
    Star insert(Star star);

    /**
     * 修改数据
     *
     * @param star 实例对象
     * @return 实例对象
     */
    Star update(Star star);

    /**
     * 通过主键删除数据
     *
     * @param staId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer staId);

}