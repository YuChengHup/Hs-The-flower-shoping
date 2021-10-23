package com.hs.controller;

import com.hs.entity.Admin;
import com.hs.entity.Token;
import com.hs.service.AdminService;
import com.hs.service.TokenService;
import com.hs.util.RespBean;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RespBean<Admin> selectOne( Integer id) {

        return RespBean.faild();
    }

    @PostMapping("/login")
    public RespBean<Admin> login(Integer admId, String passwd,ServletResponse response) {




        Admin admin = adminService.queryById(admId, passwd);
        if(admin==null){
            return RespBean.faild();
        }else{
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setAdmId(admId);
            tokenService.insert(token);
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("token",token.getToken());
            return RespBean.success(admin);
        }
    }

}