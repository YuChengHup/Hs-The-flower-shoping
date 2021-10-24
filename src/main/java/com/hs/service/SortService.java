package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Sort;
import com.hs.entity.SortVO;

import java.util.List;

/**
 * (Sort)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SortService {

    Integer PAGESIZE=5;   // 每页显示几个
    /**
     * 通过ID查询单条数据
     *
     * @param sorId 主键
     * @return 实例  SortVO  扩展对象
     */
    SortVO queryById(Integer sorId);

    /**
     * 分页 全查
     * @param pageNum 第几页
     * @return
     */
    PageInfo<SortVO> queryAll(Integer pageNum);

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    int insert(Sort sort);

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    int update(Sort sort);

    /**
     * 通过主键删除数据
     *
     * @param sorId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sorId);

}