package com.hs.mapper;

import com.hs.entity.Consumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Consumer)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface ConsumerMapper {

    /**
     * 通过id查询对象
     */
    Consumer selectById(int conId);
    /**
     * 通过ID查询单条数据
     *
     * @param  consumer
     * @return 实例对象
     */
    Consumer queryById(Consumer consumer);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Consumer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param consumer 实例对象
     * @return 对象列表
     */
    List<Consumer> queryAll(Consumer consumer);

    /**
     * 新增数据
     *
     * @param consumer 实例对象
     * @return 影响行数
     */
    int insert(Consumer consumer);

    /**
     * 修改数据
     *
     * @param consumer 实例对象
     * @return 影响行数
     */
    int update(Consumer consumer);

    /**
     * 通过主键删除数据
     *
     * @param  consumer
     * @return 影响行数
     */
    int deleteById(Consumer consumer);


    /**
     * 查询所有会员信息
     * @return
     */
    List<Consumer> findAll();

    /**
     * 查询已删除的会员信息
     */

    List<Consumer> findDeleteAll();

    /**
     * 通过id查找客户信息
     * @param consumer
     * @return
     */
    Consumer findById(Consumer consumer);

    /**
     * 添加会员
     */
    int addConsumer(Consumer consumer);

    /**
     * 查询数量
     * @return
     */
    Long queryNum();

}