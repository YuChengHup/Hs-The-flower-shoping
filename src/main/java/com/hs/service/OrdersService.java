package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.*;

import java.util.List;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param ordId 主键
     * @return 实例对象
     */
    Orders queryById(Integer ordId);

    /**
     * 查询所有数据，并分页
     *
     * @param page 查询起始位置
     * @return 对象列表
     */
    PageInfo<Orders> queryAllByLimit(int page);

    /**
     * 通过实体类查询对象，并分页
     */
     PageInfo<Orders> queryAllAndLimit(int page,Orders orders);


    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param ordId 主键
     * @return 是否成功
     */
    int deleteById(Integer ordId);

    /**
     * 查询数量
     * @return
     */
    Long queryNum();
}