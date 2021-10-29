package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.*;
import com.hs.service.SingleService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/end/single")
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

    @RequestMapping ("selectAll")
    public RespBean<PageInfo<Single>> selectAll(int page){
        PageInfo<Single> pageInfo= singleService.queryAllByLimit(page);
        RespBean<PageInfo<Single>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping ("selectAllBySingle")
    public RespBean<PageInfo<Single>> selectAllByOrders(int page, Single single, Commodity commodity){
        single.setCommodity(commodity);
        PageInfo<Single> pageInfo = singleService.queryAllAndLimit(page,single);
        RespBean<PageInfo<Single>> resp=new RespBean<>();
        resp.setData(pageInfo);
        return resp;
    }

    @RequestMapping("update")
    public RespBean<String> updateOrders(Single single, Commodity commodity){
        single.setCommodity(commodity);
        int i = singleService.update(single);
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
        int i = singleService.deleteById(id);
        RespBean<String> resp=new RespBean<>();
        if (i>=1){
            resp.setData("删除成功");
        }else {
            resp.setData("删除失败");
        }
        return resp;
    }

    /**
     * 添加单一订单，同时添加其他订单
     */
    @RequestMapping("/insert")
    public RespBean<String> insert(Location location,int[]ints ){
        int a=ints.length;
        int i = singleService.insert(ints, location);
        RespBean<String> resp=new RespBean<>();
        if (i!=4*a+2){
            resp.setCode(201);
            resp.setData("提交订单失败");
        }else{
            resp.setCode(200);
            resp.setData("提交订单成功");
        }
        return resp;
    }

}