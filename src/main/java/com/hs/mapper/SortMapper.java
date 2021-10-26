package com.hs.mapper;

import com.hs.entity.Sort;
import com.hs.entity.SortVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Sort)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SortMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param sorId 主键
     * @return 实例对象
     */
    SortVO queryById(Integer sorId);


    /**
     *  多条数据，分页
     * @return
     */
    List<SortVO> queryAll();

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int insert(Sort sort);

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int update(Sort sort);

    /**
     * 通过主键删除数据
     *
     * @param sorId 主键
     * @return 影响行数
     */
    int deleteById(Integer sorId);

    /**
     *
     * @param sizId
     * @return
     */
    List<SortVO> queryBySizId(Integer sizId);

}