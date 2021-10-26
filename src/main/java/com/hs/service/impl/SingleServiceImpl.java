package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Orders;
import com.hs.entity.Single;
import com.hs.mapper.SingleMapper;
import com.hs.service.SingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Single)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class SingleServiceImpl implements SingleService {
    private int size=3;

    @Resource
    private SingleMapper singleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param sinId 主键
     * @return 实例对象
     */
    @Override
    public Single queryById(Integer sinId) {
        return this.singleMapper.queryById(sinId);
    }


    @Override
    public PageInfo<Single> queryAllByLimit(int page) {
        PageHelper.startPage(page,size);
        Single single=new Single();
        List<Single> singleList = singleMapper.queryAll1(single);
        PageInfo<Single> pageInfo=new PageInfo<>(singleList);
        return pageInfo;
    }

    @Override
    public PageInfo<Single> queryAllAndLimit(int page, Single single) {
        PageHelper.startPage(page,size);
        List<Single> singleList = singleMapper.queryAll(single);
        PageInfo<Single> pageInfo=new PageInfo<>(singleList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    @Override
    public Single insert(Single single) {
        this.singleMapper.insert(single);
        return single;
    }

    /**
     * 修改数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Single single) {
        return this.singleMapper.update(single);
    }

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer sinId) {
        return this.singleMapper.deleteById(sinId);
    }
}