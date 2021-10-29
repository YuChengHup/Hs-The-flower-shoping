package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Cart;
import com.hs.entity.Location;
import com.hs.entity.Orders;
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
     * 查询所有数据，并分页
     *
     * @param page 查询起始位置
     * @return 对象列表
     */
    PageInfo<Single> queryAllByLimit(int page);

    /**
     * 通过实体类查询对象，并分页
     */
    PageInfo<Single> queryAllAndLimit(int page,Single single);


    /**
     * 新增数据
     *
     * @return 实例对象
     */
    int insert(int[] ints, Location location);

    /**
     * 修改数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    int update(Single single);

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 是否成功
     */
    int deleteById(Integer sinId);

}