package com.hs.service.impl;

import com.hs.entity.Photo;
import com.hs.mapper.PhotoMapper;
import com.hs.service.PhotoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Photo)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    @Resource
    private PhotoMapper photoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param phoId 主键
     * @return 实例对象
     */
    @Override
    public Photo queryById(Integer phoId) {
        return this.photoMapper.queryById(phoId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Photo> queryAllByLimit(int offset, int limit) {
        return this.photoMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    @Override
    public Photo insert(Photo photo) {
        this.photoMapper.insert(photo);
        return photo;
    }

    /**
     * 修改数据
     *
     * @param photo 实例对象
     * @return 实例对象
     */
    @Override
    public Photo update(Photo photo) {
        this.photoMapper.update(photo);
        return this.queryById(photo.getPhoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param phoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer phoId) {
        return this.photoMapper.deleteById(phoId) > 0;
    }
}