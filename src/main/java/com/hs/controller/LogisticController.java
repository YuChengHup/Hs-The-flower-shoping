package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Consumer;
import com.hs.entity.Location;
import com.hs.entity.Logistic;
import com.hs.entity.Orders;
import com.hs.service.LogisticService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/end/logistic")
public class LogisticController {
    /**
     * 服务对象
     */
    @Autowired
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

    @RequestMapping ("selectAll")
    public RespBean<PageInfo<Logistic>> selectAll(int page){
        PageInfo<Logistic> pageInfo= logisticService.queryAllByLimit(page);
        RespBean<PageInfo<Logistic>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping ("selectAllByLogistic")
    public RespBean<PageInfo<Logistic>> selectAllByOrders(int page,Logistic logistic, Orders orders){
        logistic.setOrders(orders);
        PageInfo<Logistic> pageInfo = logisticService.queryAllAndLimit(page, logistic);
        RespBean<PageInfo<Logistic>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping("update")
    public RespBean<String> updateOrders(Logistic logistic,Orders orders){
        logistic.setOrders(orders);
        int i = logisticService.update(logistic);
        RespBean<String> resp=new RespBean();
        if (i>=1){
            resp.setData("修改成功");
        }else {
            resp.setData("修改失败");
        }
        return resp;
    }

    @RequestMapping("delete")
    public RespBean<String> deleteById(String id){
        int i = logisticService.deleteById(id);
        RespBean<String> resp=new RespBean<>();
        if (i>=1){
            resp.setData("删除成功");
        }else {
            resp.setData("删除失败");
        }
        return resp;
    }

}