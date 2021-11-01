package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Commodity;
import com.hs.entity.CommodityVO;
import com.hs.entity.FrontRole;
import com.hs.entity.Photo;
import com.hs.service.CommodityService;
import com.hs.service.PhotoService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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


    @Autowired
    private PhotoService photoService;
    /**
     * 查询所有商品，为了销售数量表和利润表
     */
    @RequestMapping("/selectAllCommodity")
    private RespBean<List<CommodityVO>> selectAllCommodity(){
        Commodity commodity=new Commodity();
        List<CommodityVO> commodityVOList = commodityService.selectAll(commodity);
        RespBean<List<CommodityVO>> resp=new RespBean();
        resp.setCode(200);
        resp.setData(commodityVOList);
        return resp;
    }

    /**
     * 通过主键查询单条数据        ================已测，没问题====
     *
     * @param comId 主键
     * @return 单条数据
     */
    @GetMapping("/select_one/{comId}")
    public RespBean<CommodityVO> selectOne(@PathVariable("comId") Integer comId) {
        CommodityVO commodityVO = commodityService.queryById(comId);
        return RespBean.success(commodityVO);
    }

    @GetMapping("/id_unique/{comId}")
    public RespBean<Boolean> idUnique(@PathVariable("comId") Integer comId) {
        boolean b = commodityService.idUnique(comId);
        return RespBean.success(b);
    }

    /**
     * 查询所有,分页          动态sql     ================已测，没问题====
     *
     * @param pageNum 第几页
     * @return
     */
    @PostMapping("/query_all/{pageNum}")
    public RespBean<PageInfo<CommodityVO>> queryAll(@PathVariable("pageNum") Integer pageNum, Commodity commodity) {
        PageInfo<CommodityVO> commodityPageInfo = commodityService.queryAll(pageNum, commodity);
        return RespBean.success(commodityPageInfo);
    }

    /**
     * 根据花期查询                    ================已测，没问题=======
     *
     * @param pageNum 第几页
     * @param sizId   花期分类编号
     * @return
     */
    @GetMapping("/query_all_by_siz_id/{sizId}/{pageNum}")
    public RespBean<PageInfo<CommodityVO>> queryAllBySizId(@PathVariable("pageNum") Integer pageNum, @PathVariable("sizId") Integer sizId) {
        PageInfo<CommodityVO> commodityPageInfo = commodityService.queryAllBySizId(sizId, pageNum);
        return RespBean.success(commodityPageInfo);
    }

    /**
     * 添加数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @PostMapping("/insert_one")
    public RespBean<Commodity> insertOne(@RequestParam("comId") Integer comId, Commodity commodity, @RequestParam("phoUrl") MultipartFile[] multipartFiles) {

        List<Photo> photoList = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {

            if (file != null) {
                String filename = file.getOriginalFilename();
                if (filename != null) {
                    String name = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
                    Photo photo = new Photo();
                    photo.setPhoUrl(name);
                    photo.setComId(comId);
                    photo.setPhoDefault(0);
                    photo.setBySp1(LocalDateTime.now());
                    photoList.add(photo);

                }
            }
        }

        commodity.setGmtCreate(LocalDateTime.now());
        commodity.setGmtModified(LocalDateTime.now());
        commodity.setComId(comId);
        commodity.setComVolume(0);
        int i = commodityService.insert(commodity);
        if (i > 0) {
            for (Photo photo : photoList) {
                photoService.insert(photo);
            }
            for (int j = 0; j < multipartFiles.length; j++) {
                try {
                    multipartFiles[j].transferTo(new File("E:\\web-shop-group1\\web-shop-front\\images\\" + photoList.get(j).getPhoUrl()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return RespBean.success(commodity);
        }
        return RespBean.faild();
    }

    /**
     * 修改数据                    ================已测，没问题====
     *
     * @param commodity 修改的对象
     * @return 修改后的实例对象
     */
    @PutMapping("/update_one")
    public RespBean<Commodity> updateOne(Commodity commodity) {
        commodity.setGmtModified(LocalDateTime.now());
        int i = commodityService.update(commodity);
        if (i > 0) {
            return RespBean.success(commodity);
        }
        return RespBean.faild();
    }

    /**
     * 删除数据                       ================已测，没问题，restful====
     *
     * @param comId 商品编号
     * @return boolean
     */
    @DeleteMapping("/delete_one/{comId}")
    public RespBean<Boolean> insertOne(@PathVariable("comId") Integer comId) {
        boolean b = commodityService.deleteById(comId);
        if (b) {
            return RespBean.success();
        }
        return RespBean.faild();
    }

    /**
     * 查询数量
     * @return
     */
    @GetMapping("/query_num")
    public RespBean<Long> queryNum() {
        return RespBean.success(commodityService.queryNum());
    }



    @PostMapping("/query_all_front/{pageNum}")
    public RespBean<PageInfo<CommodityVO>> queryAllFront(@PathVariable("pageNum") Integer pageNum, FrontRole frontRole) {
        PageInfo<CommodityVO> commodityPageInfo = commodityService.queryAllFront(pageNum, frontRole);
        return RespBean.success(commodityPageInfo);
    }
}