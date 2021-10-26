package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Orders;
import com.hs.mapper.OrdersMapper;
import com.hs.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    private int size=3;

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
     * @param page 查询起始位置
     * orders 为空,查询所有
     * @return 对象列表
     */
    @Override
    public PageInfo<Orders> queryAllByLimit(int page) {
        PageHelper.startPage(page,size);
        Orders orders=new Orders();
        List<Orders> ordersList = ordersMapper.queryAll1(orders);
        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);
        return pageInfo;

    }



    @Override
    public PageInfo<Orders> queryAllAndLimit(int page,Orders orders) {
        PageHelper.startPage(page,size);
        List<Orders> ordersList = ordersMapper.queryAll(orders);
        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);
        return pageInfo;
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
    public int update(Orders orders) {
        return this.ordersMapper.update(orders);
    }

    /**
     * 通过主键删除数据
     *
     * @param ordId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer ordId) {
        return this.ordersMapper.deleteById(ordId);
    }
}