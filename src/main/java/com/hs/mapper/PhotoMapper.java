package com.hs.mapper;

import com.hs.entity.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Photo)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface PhotoMapper {

    /**
     * 根据商品找图片
     * @param comId 商品编号
     * @return
     */
    List<Photo> queryById(Integer comId);


    /**
     * 新增数据
     *
     * @param photo 实例对象
     * @return 影响行数
     */
    int insert(Photo photo);

    /**
     * 修改数据
     *
     * @param photo 实例对象
     * @return 影响行数
     */
    int update(Photo photo);

    /**
     * 通过主键删除数据
     *
     * @param phoId 主键
     * @return 影响行数
     */
    int deleteById(Integer phoId);

}