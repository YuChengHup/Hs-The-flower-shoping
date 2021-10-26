package com.hs.service.impl;

import com.hs.entity.Size;
import com.hs.mapper.SizeMapper;
import com.hs.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Size)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeMapper sizeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param sizId 主键
     * @return 实例对象
     */
    @Override
    public Size queryById(Integer sizId) {
        return sizeMapper.queryById(sizId);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<Size> queryAll() {
        return sizeMapper.queryAll();
    }

}