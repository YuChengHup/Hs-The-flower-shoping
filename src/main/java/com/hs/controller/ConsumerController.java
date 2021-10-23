package com.hs.controller;

import com.hs.entity.Consumer;
import com.hs.service.ConsumerService;
import com.hs.util.RespBean;
import com.hs.util.ResponseEntity;
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
@RequestMapping("consumer")
public class ConsumerController {
    /**
     * 服务对象
     */
    @Resource
    private ConsumerService consumerService;

    /**
     * 通过主键查询单条数据
     *
     * @param conId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ResponseEntity<Consumer> selectOne(Integer conId) {
        Consumer consumer = consumerService.queryById(conId);
        ResponseEntity<Consumer> resp=new ResponseEntity<>();
        resp.setData(consumer);
        return resp;
    }

}