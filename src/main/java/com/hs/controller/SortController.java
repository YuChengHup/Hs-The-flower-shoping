package com.hs.controller;

import com.hs.entity.Sort;
import com.hs.service.SortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("sort")
public class SortController {
    /**
     * 服务对象
     */
    @Resource
    private SortService sortService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sort selectOne(Integer id) {
        return this.sortService.queryById(id);
    }

}