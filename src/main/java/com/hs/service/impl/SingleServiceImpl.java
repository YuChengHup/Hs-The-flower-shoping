package com.hs.service.impl;

import com.hs.entity.Single;
import com.hs.mapper.SingleMapper;
import com.hs.service.SingleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Single)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("singleService")
public class SingleServiceImpl implements SingleService {
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

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Single> queryAllByLimit(int offset, int limit) {
        return this.singleMapper.queryAllByLimit(offset, limit);
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
    public Single update(Single single) {
        this.singleMapper.update(single);
        return this.queryById(single.getSinId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sinId) {
        return this.singleMapper.deleteById(sinId) > 0;
    }
}