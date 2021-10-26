package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Sort;
import com.hs.entity.SortVO;
import com.hs.service.SortService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/sort")
public class SortController {
    /**
     * 服务对象
     */
    @Autowired
    private SortService sortService;

    /**
     * 通过主键查询单条数据                 ============已测，没问题================
     *
     * @param sorId 主键
     * @return 单条数据
     */
    @GetMapping("/query_one/{sorId}")
    public RespBean<SortVO> queryOne(@PathVariable("sorId") Integer sorId) {
        SortVO sortVO = sortService.queryById(sorId);
        if (sortVO == null) {
            return RespBean.faild();
        } else {
            return RespBean.success(sortVO);
        }
    }

    /**
     * 查询所有  分页                         ============已测，没问题================
     *
     * @param pageNum 第几页
     * @return
     */
    @GetMapping("/query_all/{pageNum}")
    public RespBean<PageInfo<SortVO>> queryAll(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<SortVO> sortVOPageInfo = sortService.queryAll(pageNum);
        return RespBean.success(sortVOPageInfo);

    }

    /**
     *
     * @param sizId
     * @return
     */
    @GetMapping("/query_by_siz_id/{sizId}")
    public RespBean<List<SortVO>> queryBySizId(@PathVariable("sizId") Integer sizId) {
        List<SortVO> sortVOList = sortService.queryBySizId(sizId);
        return RespBean.success(sortVOList);

    }

    /**
     * 插入数据                     ============已测，没问题================
     *
     * @param sort
     * @return
     */
    @PostMapping("/insert_one")
    public RespBean<Integer> insertOne(Sort sort) {
        int i = sortService.insert(sort);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }

    /**
     * 修改                     ============已测，没问题================
     *
     * @param sort
     * @return
     */
    @PutMapping("/update_one")
    public RespBean<Integer> updateOne(Sort sort) {
        int i = sortService.update(sort);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }


    /**
     * 删除                     ============已测，没问题================
     *
     * @param sor_id
     * @return
     */
    @DeleteMapping("/delete_one/{sor_id}")
    public RespBean<Boolean> deleteOne(@PathVariable("sor_id") Integer sor_id) {
        Boolean b = sortService.deleteById(sor_id);
        if (b) {
            return RespBean.success(b);
        }
        return RespBean.faild();
    }

}