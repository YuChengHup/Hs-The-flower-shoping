package com.hs.service.impl;

import com.hs.entity.Statistic;
import com.hs.mapper.StatisticMapper;
import com.hs.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Statistic)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {
    @Resource
    private StatisticMapper statisticMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param staId 主键
     * @return 实例对象
     */
    @Override
    public Statistic queryById(Integer staId) {
        return this.statisticMapper.queryById(staId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Statistic> queryAllByLimit(int offset, int limit) {
        return this.statisticMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param statistic 实例对象
     * @return 实例对象
     */
    @Override
    public Statistic insert(Statistic statistic) {
        this.statisticMapper.insert(statistic);
        return statistic;
    }

    /**
     * 修改数据
     *
     * @param statistic 实例对象
     * @return 实例对象
     */
    @Override
    public Statistic update(Statistic statistic) {
        this.statisticMapper.update(statistic);
        return this.queryById(statistic.getStaId());
    }

    /**
     * 通过主键删除数据
     *
     * @param staId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer staId) {
        return this.statisticMapper.deleteById(staId) > 0;
    }
}