package com.hs.controller;

import com.hs.entity.Photo;
import com.hs.service.PhotoService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * (Photo)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/photo")
public class PhotoController {
    /**
     * 服务对象
     */
    @Autowired
    private PhotoService photoService;

    /**
     * 通过主键查询单条数据
     *
     * @param photo 实例对象
     * @return 单条数据
     */
    @GetMapping("/query")
    public RespBean<List<Photo>> select(Photo photo) {
        List<Photo> photoList = photoService.queryByPhoto(photo);
        return RespBean.success(photoList);
    }

    @PostMapping("/insert")
    public RespBean<Integer> insert(MultipartFile file, Photo photo) {

        Long num = photoService.queryNumByComId(photo.getComId());
        if (num >= 5) {
            return RespBean.faild();
        }
        String filename = file.getOriginalFilename();
        String name = "";
        if (filename != null) {
            name = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            photo.setPhoUrl(name);
            photo.setPhoDefault(0);
            photo.setBySp1(LocalDateTime.now());
        }

        int i = photoService.insert(photo);
        if (i > 0) {
            try {
                file.transferTo(new File("/root/nginx-www/www/images/" + name));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return RespBean.success(i);
        }
        return RespBean.faild();
    }

    @PutMapping("/update")
    public RespBean<Integer> update(Photo photo) {
        int i = photoService.update(photo);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }

    @DeleteMapping("/delete")
    public RespBean<Boolean> delete(Photo photo) {
        boolean b = photoService.deleteById(photo);
        if (b) {
            return RespBean.success(b);
        }
        return RespBean.faild();
    }

}