package com.hs.service;

import com.hs.entity.Photo;

import java.util.List;

/**
 * (Photo)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface PhotoService {

    /**
     * 通过ID查询单条数据
     *
     * @param phoId 主键
     * @return 实例对象
     */
    Photo queryById(Integer phoId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Photo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    Photo insert(Photo photo);

    /**
     * 修改数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    Photo update(Photo photo);

    /**
     * 通过主键删除数据
     *
     * @param phoId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer phoId);

}