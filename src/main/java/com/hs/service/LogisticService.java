package com.hs.service;

import com.hs.entity.Logistic;

import java.util.List;

/**
 * (Logistic)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface LogisticService {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    Logistic queryById(String logId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Logistic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param logistic 实例对象
     * @return 实例对象
     */
    Logistic insert(Logistic logistic);

    /**
     * 修改数据
     *
     * @param logistic 实例对象
     * @return 实例对象
     */
    Logistic update(Logistic logistic);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    boolean deleteById(String logId);

}