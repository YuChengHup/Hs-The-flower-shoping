package com.hs.mapper;

import com.hs.entity.Commodity;
import com.hs.entity.CommodityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Commodity)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface CommodityMapper {

    /**
     * 通过ID查询单条数据，可以用
     *
     * @param comId 主键
     * @return 实例对象
     */
    CommodityVO queryById(Integer comId);

    /**
     * 通过实体作为筛选条件查询，可以用
     *
     * @return 对象列表
     */
    List<CommodityVO> queryAll(Commodity commodity);


    /**
     * 查一个种类
     * @param sizId 种类编号
     * @return
     */
    List<CommodityVO> queryAllBySizId(Integer sizId);


    /**
     * 新增数据，可用
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int insert(Commodity commodity);

    /**
     * 修改数据，可用
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int update(Commodity commodity);

    /**
     * 通过主键删除数据，可用
     *
     * @param comId 主键
     * @return 影响行数
     */
    int deleteById(Integer comId);

    /**
     * 判断id唯一
     * @param comId
     * @return
     */
    Long idUnique(Integer comId);


    /**
     * 查询数量
     * @return
     */
    Long queryNum();

}