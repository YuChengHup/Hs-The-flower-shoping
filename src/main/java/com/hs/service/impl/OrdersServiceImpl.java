package com.hs.service.impl;

import com.hs.entity.Orders;
import com.hs.mapper.OrdersMapper;
import com.hs.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param ordId 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer ordId) {
        return this.ordersMapper.queryById(ordId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit) {
        return this.ordersMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        this.ordersMapper.insert(orders);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersMapper.update(orders);
        return this.queryById(orders.getOrdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param ordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ordId) {
        return this.ordersMapper.deleteById(ordId) > 0;
    }
}