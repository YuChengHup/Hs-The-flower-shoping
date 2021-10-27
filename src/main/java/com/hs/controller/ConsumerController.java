package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Consumer;
import com.hs.service.ConsumerService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
     * @param consumer
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public RespBean<Consumer> selectOne(Consumer consumer) {
        RespBean<Consumer> respBean=new RespBean<>();
        Consumer consumer1 = consumerService.queryById(consumer);
        respBean.setCode(200);
        respBean.setMessage("ok");
        respBean.setData(consumer1);
        return respBean;
    }


    @RequestMapping("/findAll")
    public RespBean<PageInfo<Consumer>> findAll(int pageNum,int pageSize){
        return RespBean.success(consumerService.findAll(pageNum,pageSize));
    }

    @RequestMapping("/findDeleteAll")
    public RespBean<PageInfo<Consumer>> findDeleteAll(int pageNum,int pageSize){
        return RespBean.success(consumerService.findDeleteAll(pageNum,pageSize));
    }


    /**
     * 多条件模糊查询
     */
    @RequestMapping("/queryAll")
    public RespBean<PageInfo<Consumer>> queryAll(int pageNum,int pageSize,Consumer consumer){
        return RespBean.success(consumerService.queryAll(pageNum,pageSize,consumer));
    }

    @RequestMapping("/addCustomer")
    public RespBean<String> addCustomer(Consumer consumer){
        consumer.setGmtCreate(LocalDateTime.now());
        consumer.setGmtModified(LocalDateTime.now());
        consumer.setConStatus(0);

        RespBean<String> respBean=new RespBean<>();
        int i = consumerService.addConsumer(consumer);

        if (i>0){
            respBean.setCode(1001);
            respBean.setMessage("添加成功");
            respBean.setData("添加成功");
            return respBean;
        }

        respBean.setCode(1002);
        respBean.setMessage("添加失败");
        respBean.setData("添加失败");
        return respBean;
    }

    /**
     * 通过用户名查找客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/findConsumerByUsername")
    public RespBean<List<Consumer>> queryConsumerByUsername(Consumer consumer){
        List<Consumer> consumers = consumerService.queryConsumerByUsername(consumer);
        if (consumers!=null){
            return RespBean.success(consumers);
        }
        return RespBean.faild();
    }

    /**
     * 通过主键删除客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/deleteById")
    public RespBean<Integer> deleteById(Consumer consumer){
        return RespBean.success(consumerService.deleteById(consumer));
    }

    /**
     * 通过id修改状态,假删除
     * @param consumer
     * @return
     */
    @RequestMapping("/updateById")
    public RespBean<Integer> updateById(Consumer consumer){
        return RespBean.success(consumerService.update(consumer));
    }

    /**
     * 通过id查询单条客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/findById")
    public RespBean<Consumer> findById(Consumer consumer){
        return RespBean.success(consumerService.findById(consumer));
    }


    @GetMapping("/query_num")
    public RespBean<Long> queryNum(){
        return RespBean.success(consumerService.queryNum());
    }
}