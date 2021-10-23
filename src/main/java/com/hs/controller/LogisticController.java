package com.hs.controller;

import com.hs.entity.Logistic;
import com.hs.service.LogisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Logistic)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("logistic")
public class LogisticController {
    /**
     * 服务对象
     */
    @Resource
    private LogisticService logisticService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Logistic selectOne(String id) {
        return this.logisticService.queryById(id);
    }

}