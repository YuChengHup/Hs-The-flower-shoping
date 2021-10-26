package com.hs.controller;

import com.hs.entity.Size;
import com.hs.service.SizeService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Size)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/size")
public class SizeController {
    /**
     * 服务对象
     */
    @Autowired
    private SizeService sizeService;

    /**
     * 通过主键查询单条数据              =============已测，没问题==============
     *
     * @param sizId 主键
     * @return 单条数据
     */
    @GetMapping("/query_one/{sizId}")
    public RespBean<Size> queryOne(@PathVariable("sizId") Integer sizId) {
        Size size = sizeService.queryById(sizId);
        if(size==null){
            return RespBean.faild();
        }else{
            return RespBean.success(size);
        }
    }

    /**
     * 查询所有                       =============已测，没问题==============
     * @return 多条数据
     */
    @GetMapping("/query_all")
    public List<Size> queryAll() {
        return sizeService.queryAll();
    }

}