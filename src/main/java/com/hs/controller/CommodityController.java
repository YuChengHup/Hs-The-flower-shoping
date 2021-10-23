package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.service.CommodityService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Commodity)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    /**
     * 服务对象
     */
    @Autowired
    private CommodityService commodityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Commodity selectOne(Integer id) {
        return this.commodityService.queryById(id);
    }

    /**
     * 查询所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/queryall/{pageNum}/{pageSize}")
    public RespBean<PageInfo<Commodity>> queryAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageInfo<Commodity> commodityPageInfo = commodityService.queryAll(pageNum, pageSize);
        return RespBean.success(commodityPageInfo);
    }

}