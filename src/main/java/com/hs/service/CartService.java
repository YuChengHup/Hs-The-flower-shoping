package com.hs.service;

import com.hs.entity.Cart;
import com.hs.entity.CartVO;

import java.util.List;

/**
 * (Cart)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface CartService {

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    Cart queryById(Integer carId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cart> queryAllByLimit(int offset, int limit);

    List<Cart> queryAll1(Cart cart);
    /**
     * 通过conId查询购物车信息
     * @param conId
     * @return
     */
    List<CartVO> findCommodity(Integer conId);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    int insert(Cart cart);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    int update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carId);

}