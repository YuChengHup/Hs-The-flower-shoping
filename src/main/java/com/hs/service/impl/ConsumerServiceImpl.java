package com.hs.service.impl;

import com.hs.entity.Consumer;
import com.hs.mapper.ConsumerMapper;
import com.hs.service.ConsumerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Consumer)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {
    @Resource
    private ConsumerMapper consumerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param conId 主键
     * @return 实例对象
     */
    @Override
    public Consumer queryById(Integer conId) {
        return this.consumerMapper.queryById(conId);
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
    public Consumer update(Consumer consumer) {
        this.consumerMapper.update(consumer);
        return this.queryById(consumer.getConId());
    }

    /**
     * 通过主键删除数据
     *
     * @param conId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer conId) {
        return this.consumerMapper.deleteById(conId) > 0;
    }
}