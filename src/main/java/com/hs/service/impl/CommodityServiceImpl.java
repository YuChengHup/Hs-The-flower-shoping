package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.entity.CommodityVO;
import com.hs.entity.FrontRole;
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

    @Override
    public List<CommodityVO> selectAll(Commodity commodity) {
        return commodityMapper.queryAll(commodity);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param comId 主键
     * @return 实例对象
     */
    @Override
    public CommodityVO queryById(Integer comId) {
        return commodityMapper.queryById(comId);
    }

    /**
     * 查询多条数据
     *
     * @param pageNum 查询起始位置
     * @return 对象列表
     */
    @Override
    public PageInfo<CommodityVO> queryAll(Integer pageNum, Commodity commodity) {
        PageHelper.startPage(pageNum, PAGESIZE);
        List<CommodityVO> commodityList = commodityMapper.queryAll(commodity);
        return new PageInfo<>(commodityList);
    }

    /**
     * 通过种类查询
     *
     * @param sizId   种类编号
     * @param pageNum 第几页
     * @return
     */
    @Override
    public PageInfo<CommodityVO> queryAllBySizId(Integer sizId, Integer pageNum) {
        PageHelper.startPage(pageNum, PAGESIZE);
        List<CommodityVO> commodityList = commodityMapper.queryAllBySizId(sizId);
        return new PageInfo<>(commodityList);
    }

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Commodity commodity) {

        return commodityMapper.update(commodity);
    }

    /**
     * 通过主键删除数据
     *
     * @param comId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer comId) {
        return commodityMapper.deleteById(comId) > 0;
    }

    @Override
    public boolean idUnique(Integer comId) {

        return commodityMapper.idUnique(comId)<=0;
    }

    /**
     * 查询数量
     * @return
     */
    @Override
    public Long queryNum() {
        return commodityMapper.queryNum();
    }

    @Override
    public PageInfo<CommodityVO> queryAllFront(Integer pageNum,FrontRole frontRole) {
        PageHelper.startPage(pageNum,frontRole.getPageSize());
        List<CommodityVO> commodityVOList = commodityMapper.queryAllFront(frontRole);
        return new PageInfo<>(commodityVOList);
    }

    @Override
    public Long numBySorId(Integer sorId) {
        return commodityMapper.numBySorId(sorId);
    }


}