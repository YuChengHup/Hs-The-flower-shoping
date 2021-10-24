package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Sort;
import com.hs.entity.SortVO;
import com.hs.mapper.SortMapper;
import com.hs.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Sort)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param sorId 主键
     * @return 实例对象
     */
    @Override
    public SortVO queryById(Integer sorId) {
        return sortMapper.queryById(sorId);
    }

    /**
     *
     * @param pageNum 第几页
     * @return 多条数据
     */
    @Override
    public PageInfo<SortVO> queryAll(Integer pageNum) {
        PageHelper.startPage(pageNum, PAGESIZE);
        List<SortVO> sortVOList = sortMapper.queryAll();
        return new PageInfo<>(sortVOList);
    }

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Sort sort) {
        return sortMapper.insert(sort);

    }

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Sort sort) {
        return sortMapper.update(sort);

    }

    /**
     * 通过主键删除数据
     *
     * @param sorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sorId) {
        return sortMapper.deleteById(sorId) > 0;
    }
}