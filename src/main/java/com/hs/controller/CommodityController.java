package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.service.CommodityService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * (Commodity)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/commodity")
public class CommodityController {
    /**
     * 服务对象
     */
    @Autowired
    private CommodityService commodityService;

    /**
     * 通过主键查询单条数据        ================已测，没问题====
     *
     * @param comId 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{comId}")
    public Commodity selectOne(@PathVariable("comId") Integer comId) {
        return commodityService.queryById(comId);
    }

    /**
     * 查询所有,分页             ================已测，没问题====
     * @param pageNum 第几页
     * @param pageSize 每页显示几个
     * @return
     */
    @GetMapping("/queryall/{pageNum}/{pageSize}")
    public RespBean<PageInfo<Commodity>> queryAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        PageInfo<Commodity> commodityPageInfo = commodityService.queryAll(pageNum, pageSize);
        return RespBean.success(commodityPageInfo);
    }

    /**
     * 添加数据                   ================已测，没问题====
     * @param commodity 实例对象
     * @return 实例对象
     */
    @PostMapping("/insertOne")
    public RespBean<Commodity> insertOne(Commodity commodity) {
        commodity.setGmtCreate(LocalDateTime.now());
        commodity.setGmtModified(LocalDateTime.now());
        int i = commodityService.insert(commodity);
        if(i>0){
            return RespBean.success(commodity);
        }
        return RespBean.faild();
    }

    /**
     * 修改数据                    ================已测，没问题，restful====
     * @param commodity 修改的对象
     * @return 修改后的实例对象
     */
    @PutMapping("/updateOne")
    public RespBean<Commodity> updateOne(Commodity commodity) {
        commodity.setGmtModified(LocalDateTime.now());
        int i = commodityService.update(commodity);
        if(i>0){
            return RespBean.success(commodity);
        }
        return RespBean.faild();
    }

    /**
     * 删除数据                       ================已测，没问题，restful====
     * @param comId 商品编号
     * @return boolean
     */
    @DeleteMapping("/deleteOne/{comId}")
    public RespBean<Boolean> insertOne(@PathVariable("comId") Integer comId) {
        boolean b = commodityService.deleteById(comId);
        if(b){
            return RespBean.success();
        }
        return RespBean.faild();
    }

}