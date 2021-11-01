package com.hs.controller;

import com.hs.entity.Location;
import com.hs.service.LocationService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Location)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/location")
public class LocationController {
    /**
     * 服务对象
     */
    @Autowired
    private LocationService locationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Location selectOne(Integer id) {
        return this.locationService.queryById(id);
    }

    @PostMapping("insert")
    public RespBean<Integer> insert(Location location) {
        location.setLocDefault(0);
        int i = locationService.insert(location);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }


    @GetMapping("all")
    public RespBean<List<Location>> quertAll(Location location) {
        List<Location> locationList = locationService.queryAll(location);
        return RespBean.success(locationList);

    }

    @DeleteMapping("local")
    public RespBean<Boolean> deleteById(Integer locId) {
        boolean b = locationService.deleteById(locId);
        if(b){
            return RespBean.success(b);
        }
        return RespBean.faild();

    }

}