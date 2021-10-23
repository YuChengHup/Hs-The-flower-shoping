package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.mapper.CommodityMapper;
import com.hs.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Commodity)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param comId 主键
     * @return 实例对象
     */
    @Override
    public Commodity queryById(Integer comId) {
        return this.commodityMapper.queryById(comId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<Commodity> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodityList = commodityMapper.queryAll();
        return new PageInfo<>(commodityList);
    }

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity insert(Commodity commodity) {
        this.commodityMapper.insert(commodity);
        return commodity;
    }

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity update(Commodity commodity) {
        this.commodityMapper.update(commodity);
        return this.queryById(commodity.getComId());
    }

    /**
     * 通过主键删除数据
     *
     * @param comId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer comId) {
        return this.commodityMapper.deleteById(comId) > 0;
    }
}