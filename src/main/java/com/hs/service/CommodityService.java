package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;

/**
 * (Commodity)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface CommodityService {

    /**
     * 通过ID查询单条数据
     *
     * @param comId 主键
     * @return 实例对象
     */
    Commodity queryById(Integer comId);

    /**
     * 查询所有
     * @return
     */
    PageInfo<Commodity> queryAll(int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    int insert(Commodity commodity);

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    int update(Commodity commodity);

    /**
     * 通过主键删除数据
     *
     * @param comId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer comId);

}