package com.hs.mapper;

import com.hs.entity.Consumer;
import com.hs.entity.Location;
import com.hs.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface OrdersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param ordId 主键
     * @return 实例对象
     */
    Orders queryById(Integer ordId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

    List<Orders> queryAll1(Orders orders);


    /**
     * 新增数量
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param ordId 主键
     * @return 影响行数
     */
    int deleteById(Integer ordId);

    Long queryNum();

}