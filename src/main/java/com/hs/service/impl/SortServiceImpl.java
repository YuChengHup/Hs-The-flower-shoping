package com.hs.service.impl;

import com.hs.entity.Sort;
import com.hs.mapper.SortMapper;
import com.hs.service.SortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("sortService")
public class SortServiceImpl implements SortService {
    @Resource
    private SortMapper sortMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param sorId 主键
     * @return 实例对象
     */
    @Override
    public Sort queryById(Integer sorId) {
        return this.sortMapper.queryById(sorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sort> queryAllByLimit(int offset, int limit) {
        return this.sortMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    public Sort insert(Sort sort) {
        this.sortMapper.insert(sort);
        return sort;
    }

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    public Sort update(Sort sort) {
        this.sortMapper.update(sort);
        return this.queryById(sort.getSorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sorId) {
        return this.sortMapper.deleteById(sorId) > 0;
    }
}