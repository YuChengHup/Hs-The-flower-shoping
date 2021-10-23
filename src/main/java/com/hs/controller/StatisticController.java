package com.hs.controller;

import com.hs.entity.Statistic;
import com.hs.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Statistic)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("statistic")
public class StatisticController {
    /**
     * 服务对象
     */
    @Resource
    private StatisticService statisticService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Statistic selectOne(Integer id) {
        return this.statisticService.queryById(id);
    }

}