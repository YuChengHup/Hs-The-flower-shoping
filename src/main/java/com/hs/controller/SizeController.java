package com.hs.controller;

import com.hs.entity.Size;
import com.hs.service.SizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Size)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("size")
public class SizeController {
    /**
     * 服务对象
     */
    @Resource
    private SizeService sizeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Size selectOne(Integer id) {
        return this.sizeService.queryById(id);
    }

}