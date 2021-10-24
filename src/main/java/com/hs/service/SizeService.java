package com.hs.service;

import com.hs.entity.Size;

import java.util.List;

/**
 * (Size)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface SizeService {

    /**
     * 通过ID查询单条数据
     *
     * @param sizId 主键
     * @return 实例对象
     */
    Size queryById(Integer sizId);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<Size> queryAll();


}