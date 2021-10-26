package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Consumer;
import com.hs.mapper.ConsumerMapper;
import com.hs.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Consumer)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param consumer
     * @return 实例对象
     */
    @Override
    public Consumer queryById(Consumer consumer) {
        return this.consumerMapper.queryById(consumer);
    }


    @Override
    public Consumer findById(Consumer consumer) {
        return consumerMapper.findById(consumer);
    }

    /**
     * 查询所有客户信息11
     * @return
     */
    @Override
    public PageInfo<Consumer> findAll(int pageNum, int pageSize) {
//        设置pageHelper
        PageHelper.startPage(pageNum,pageSize);

//        查询数据
        List<Consumer> all = consumerMapper.findAll();

//        封装分页结果
        PageInfo<Consumer> pageInfo=new PageInfo<>(all);
        return pageInfo;
    }

    /**
     * 查询所有删除客户信息
     * @return
     */
    @Override
    public PageInfo<Consumer> findDeleteAll(int pageNum, int pageSize) {
//        设置pageHelper
        PageHelper.startPage(pageNum,pageSize);

        List<Consumer> deleteAll = consumerMapper.findDeleteAll();

        PageInfo<Consumer> pageInfo=new PageInfo<>(deleteAll);
        return pageInfo;
    }


    /**
     * 多条件模糊查询
     * @param
     * @return
     */
    @Override
    public PageInfo<Consumer> queryAll(int pageNum,int pageSize,Consumer consumer) {
        PageHelper.startPage(pageNum,pageSize);

        List<Consumer> consumers = consumerMapper.queryAll(consumer);

        PageInfo<Consumer> pageInfo=new PageInfo<>(consumers);
        return pageInfo;
    }

    /**
     * 添加会员信息11
     * @param consumer
     * @return
     */
    @Override
    public int addConsumer(Consumer consumer) {
        return consumerMapper.addConsumer(consumer);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Consumer> queryAllByLimit(int offset, int limit) {
        return this.consumerMapper.queryAllByLimit(offset, limit);
    }


    /**
     * 通过条件查询客户信息
     * @param consumer
     * @return
     */
    @Override
    public List<Consumer> queryConsumerByUsername(Consumer consumer) {
        List<Consumer> consumers = consumerMapper.queryAll(consumer);
        return consumers;
    }

    /**
     * 新增数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    @Override
    public Consumer insert(Consumer consumer) {
        this.consumerMapper.insert(consumer);
        return consumer;
    }

    /**
     * 修改数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Consumer consumer) {
        return this.consumerMapper.update(consumer);
    }

    /**
     * 通过主键删除数据
     *
     * @param consumer
     * @return 是否成功
     */
    @Override
    public int deleteById(Consumer consumer) {
        return this.consumerMapper.deleteById(consumer);
    }

}