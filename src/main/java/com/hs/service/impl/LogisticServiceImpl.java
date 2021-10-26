package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Logistic;
import com.hs.entity.Orders;
import com.hs.mapper.LogisticMapper;
import com.hs.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Logistic)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class LogisticServiceImpl implements LogisticService {
    private int size=3;
    @Autowired
    private LogisticMapper logisticMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    public Logistic queryById(String logId) {
        return this.logisticMapper.queryById(logId);
    }

    /**
     * 查询多条数据
     *
     * @param page 查询起始位置
     * @return 对象列表
     */
    @Override
    public PageInfo<Logistic> queryAllByLimit(int page) {
        PageHelper.startPage(page,size);
        Logistic logistic=new Logistic();
        List<Logistic> logisticList = logisticMapper.queryAll1(logistic);
        PageInfo<Logistic> pageInfo=new PageInfo<>(logisticList);
        return pageInfo;

    }



    @Override
    public PageInfo<Logistic> queryAllAndLimit(int page,Logistic logistic) {
        PageHelper.startPage(page,size);
        List<Logistic> logisticList = logisticMapper.queryAll(logistic);
        PageInfo<Logistic> pageInfo=new PageInfo<>(logisticList);
        return pageInfo;
    }
    /**
     * 新增数据
     *
     * @param logistic 实例对象
     * @return 实例对象
     */
    @Override
    public Logistic insert(Logistic logistic) {
        this.logisticMapper.insert(logistic);
        return logistic;
    }

    /**
     * 修改数据
     *
     * @param logistic 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Logistic logistic) {
        return this.logisticMapper.update(logistic);
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String logId) {
        return this.logisticMapper.deleteById(logId);
    }
}