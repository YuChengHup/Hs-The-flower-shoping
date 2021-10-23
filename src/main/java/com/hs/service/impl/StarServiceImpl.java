package com.hs.service.impl;

import com.hs.entity.Star;
import com.hs.mapper.StarMapper;
import com.hs.service.StarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Star)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("starService")
public class StarServiceImpl implements StarService {
    @Resource
    private StarMapper starMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param staId 主键
     * @return 实例对象
     */
    @Override
    public Star queryById(Integer staId) {
        return this.starMapper.queryById(staId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Star> queryAllByLimit(int offset, int limit) {
        return this.starMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param star 实例对象
     * @return 实例对象
     */
    @Override
    public Star insert(Star star) {
        this.starMapper.insert(star);
        return star;
    }

    /**
     * 修改数据
     *
     * @param star 实例对象
     * @return 实例对象
     */
    @Override
    public Star update(Star star) {
        this.starMapper.update(star);
        return this.queryById(star.getStaId());
    }

    /**
     * 通过主键删除数据
     *
     * @param staId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer staId) {
        return this.starMapper.deleteById(staId) > 0;
    }
}