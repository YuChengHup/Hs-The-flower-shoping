package com.hs.controller;

import com.hs.entity.Single;
import com.hs.service.SingleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Single)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("single")
public class SingleController {
    /**
     * 服务对象
     */
    @Resource
    private SingleService singleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Single selectOne(Integer id) {
        return this.singleService.queryById(id);
    }

}