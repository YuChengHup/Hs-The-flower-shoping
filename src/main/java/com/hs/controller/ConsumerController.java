package com.hs.controller;

import com.hs.entity.Consumer;
import com.hs.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Consumer)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/consumer")
public class ConsumerController {
    /**
     * 服务对象
     */
    @Autowired
    private ConsumerService consumerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Consumer selectOne(Integer id) {
        return this.consumerService.queryById(id);
    }

}