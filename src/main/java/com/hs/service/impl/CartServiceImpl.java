package com.hs.service.impl;

import com.hs.entity.Cart;
import com.hs.entity.CartVO;
import com.hs.mapper.CartMapper;
import com.hs.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    @Override
    public Cart queryById(Integer carId) {
        return this.cartMapper.queryById(carId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Cart> queryAllByLimit(int offset, int limit) {
        return this.cartMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Cart> queryAll1(Cart cart) {
        List<Cart> cartList = cartMapper.queryAll(cart);
        return cartList;
    }

    @Override
    public List<CartVO> findCommodity(Integer conId) {
        return cartMapper.findCommodity(conId);
    }

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Cart cart) {

        return cartMapper.update(cart);
    }

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carId) {
        return this.cartMapper.deleteById(carId) > 0;
    }
}