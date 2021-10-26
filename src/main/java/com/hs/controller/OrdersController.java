package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Consumer;
import com.hs.entity.Location;
import com.hs.entity.Orders;
import com.hs.service.OrdersService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Autowired
    private OrdersService ordersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Orders selectOne(Integer id) {
        return this.ordersService.queryById(id);
    }

    @RequestMapping ("selectAll")
    public RespBean<PageInfo<Orders>> selectAll(int page){
        PageInfo<Orders> pageInfo= ordersService.queryAllByLimit(page);
        RespBean<PageInfo<Orders>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping ("selectAllByOrders")
    public RespBean<PageInfo<Orders>> selectAllByOrders(int page,Orders orders,Consumer consumer,Location location){
        orders.setConsumer(consumer);
        orders.setLocation(location);
        PageInfo<Orders> pageInfo = ordersService.queryAllAndLimit(page, orders);
        RespBean<PageInfo<Orders>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping("update")
    public RespBean<String> updateOrders(Orders orders, Consumer consumer, Location location){
        orders.setConsumer(consumer);
        orders.setLocation(location);
        int i = ordersService.update(orders);
        RespBean<String> resp=new RespBean();
        if (i>=1){
            resp.setData("修改成功");
        }else {
            resp.setData("修改失败");
        }
        return resp;
    }

    @RequestMapping("delete")
    public RespBean<String> deleteById(Integer id){
        int i = ordersService.deleteById(id);
        RespBean<String> resp=new RespBean<>();
        if (i>=1){
            resp.setData("删除成功");
        }else {
            resp.setData("删除失败");
        }
        return resp;
    }



}