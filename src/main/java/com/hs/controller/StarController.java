package com.hs.controller;

import com.hs.entity.Star;
import com.hs.service.StarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Star)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("star")
public class StarController {
    /**
     * 服务对象
     */
    @Resource
    private StarService starService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Star selectOne(Integer id) {
        return this.starService.queryById(id);
    }

}