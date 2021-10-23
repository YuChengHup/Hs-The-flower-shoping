package com.hs.service.impl;

import com.hs.entity.Location;
import com.hs.mapper.LocationMapper;
import com.hs.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Location)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationMapper locationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param locId 主键
     * @return 实例对象
     */
    @Override
    public Location queryById(Integer locId) {
        return this.locationMapper.queryById(locId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Location> queryAllByLimit(int offset, int limit) {
        return this.locationMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location insert(Location location) {
        this.locationMapper.insert(location);
        return location;
    }

    /**
     * 修改数据
     *
     * @param location 实例对象
     * @return 实例对象
     */
    @Override
    public Location update(Location location) {
        this.locationMapper.update(location);
        return this.queryById(location.getLocId());
    }

    /**
     * 通过主键删除数据
     *
     * @param locId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer locId) {
        return this.locationMapper.deleteById(locId) > 0;
    }
}