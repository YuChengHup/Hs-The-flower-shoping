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
     * 根据 商品编号 或 图片编号 查询
     * @param photo
     * @return
     */
    List<Photo> queryByPhoto(Photo photo);


    /**
     * 新增数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    int insert(Photo photo);

    /**
     * 修改数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    int update(Photo photo);

    /**
     *
     * @param photo
     * @return
     */
    boolean deleteById(Photo photo);

}