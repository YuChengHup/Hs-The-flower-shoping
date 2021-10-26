package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Logistic;
import com.hs.entity.Orders;

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
     * 查询所有数据，并分页
     *
     * @param page 查询起始位置
     * @return 对象列表
     */
    PageInfo<Logistic> queryAllByLimit(int page);

    /**
     * 通过实体类查询对象，并分页
     */
    PageInfo<Logistic> queryAllAndLimit(int page,Logistic logistic);

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
    int update(Logistic logistic);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    int deleteById(String logId);

}