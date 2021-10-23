package com.hs.controller;

import com.hs.entity.Photo;
import com.hs.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Photo)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("photo")
public class PhotoController {
    /**
     * 服务对象
     */
    @Resource
    private PhotoService photoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Photo selectOne(Integer id) {
        return this.photoService.queryById(id);
    }

}