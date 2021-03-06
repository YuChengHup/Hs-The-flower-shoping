package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.entity.CommodityVO;
import com.hs.entity.FrontRole;

import java.util.List;

/**
 * (Commodity)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface CommodityService {


    Integer PAGESIZE=5;   // 每页显示几个
    /**
     * 查询所有商品，为了销售数量表和利润表
     */
    List<CommodityVO> selectAll(Commodity commodity);


    /**
     * 通过ID查询单条数据
     *
     * @param comId 主键
     * @return 实例对象
     */
    CommodityVO queryById(Integer comId);




    /**
     * 查询所有
     * @return
     */
    PageInfo<CommodityVO> queryAll(Integer pageNum,Commodity commodity);

    /**
     * 查询所有,根据 sizId 种类查询
     * @param sizId 种类编号
     * @param pageNum 第几页
     * @return
     */
    PageInfo<CommodityVO> queryAllBySizId(Integer sizId,Integer pageNum);


    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    int insert(Commodity commodity);

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    int update(Commodity commodity);

    /**
     * 通过主键删除数据
     *
     * @param comId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer comId);

    /**
     * 判断id唯一
     * @param comId
     * @return
     */
    boolean idUnique(Integer comId);

    /**
     * 查询数量
     * @return
     */
    Long queryNum();


    PageInfo<CommodityVO> queryAllFront(Integer pageNum,FrontRole frontRole);

    /**
     * 查询该分类下植物数量
     * @param sorId
     * @return
     */
    Long numBySorId(Integer sorId);

}