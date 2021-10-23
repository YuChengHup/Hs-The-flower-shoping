package com.hs.service;

import com.hs.entity.Single;

import java.util.List;

/**
 * (Single)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SingleService {

    /**
     * 通过ID查询单条数据
     *
     * @param sinId 主键
     * @return 实例对象
     */
    Single queryById(Integer sinId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Single> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    Single insert(Single single);

    /**
     * 修改数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    Single update(Single single);

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sinId);

}