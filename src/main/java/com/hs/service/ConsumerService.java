package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Consumer;

import java.util.List;

/**
 * (Consumer)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface ConsumerService {

    /**
     * 通过ID查询单条数据
     *
     * @param consumer
     * @return 实例对象
     */
    Consumer queryById(Consumer consumer);

    /**
     * 通过id查询客户信息
     */
    Consumer findById(Consumer consumer);


    /**
     * 查询所有客户信息
     * @return
     */
    PageInfo<Consumer> findAll(int pageNum, int pageSize);


    /**
     * 查询已删除客户信息
     */
    PageInfo<Consumer> findDeleteAll(int pageNum,int pageSize);


    /**
     * 模糊查询，多条件查询
     * @param consumer
     * @return
     */
    PageInfo<Consumer> queryAll(int pageNum,int pageSize,Consumer consumer);

    /**
     * 添加客户信息
     */
    int addConsumer(Consumer consumer);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Consumer> queryAllByLimit(int offset, int limit);


    /**
     * 通过用户名查询客户信息
     */
    List<Consumer> queryConsumerByUsername(Consumer consumer);

    /**
     * 新增数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    Consumer insert(Consumer consumer);

    /**
     * 修改数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    int update(Consumer consumer);

    /**
     * 通过主键删除数据
     *
     * @param consumer 主键
     * @return 是否成功
     */
    int deleteById(Consumer consumer);


}