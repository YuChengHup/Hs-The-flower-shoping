package com.hs.service.impl;

import com.hs.entity.Photo;
import com.hs.mapper.PhotoMapper;
import com.hs.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Photo)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;


    /**
     *
     * @param photo
     * @return
     */
    @Override
    public List<Photo> queryByPhoto(Photo photo) {
        return photoMapper.queryByPhoto(photo);
    }

    /**
     *
     * @param photo 实例对象
     * @return
     */
    @Override
    public int insert(Photo photo) {
        return photoMapper.insert(photo);
    }

    /**
     *
     * @param photo 实例对象
     * @return
     */
    @Override
    public int update(Photo photo) {

        return photoMapper.update(photo);
    }

    /**
     *
     * @param photo
     * @return
     */
    @Override
    public boolean deleteById(Photo photo) {
        return photoMapper.deleteById(photo) > 0;
    }

    @Override
    public Long queryNumByComId(Integer comId) {
        return photoMapper.queryNumByComId(comId);
    }
}