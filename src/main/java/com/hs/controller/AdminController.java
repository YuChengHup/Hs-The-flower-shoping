package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Admin;
import com.hs.entity.Token;
import com.hs.service.AdminService;
import com.hs.service.TokenService;
import com.hs.util.RespBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/admin")
public class AdminController {


    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;

    /**
     * ============已测，没问题=====
     *
     * @param admId
     * @param passwd
     * @param response
     * @return
     */
    @PostMapping("/login")
    public RespBean<Admin> login(Integer admId, String passwd, ServletResponse response) {
        Admin admin = adminService.queryById(admId, passwd);
        if (admin == null) {
            return RespBean.faild();
        } else {

            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setAdmId(admId);
            tokenService.insert(token);
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("token", token.getToken());
            return RespBean.success(admin);

        }
    }


    /**
     * ============已测，没问题=====
     *
     * @param pageNum
     * @return
     */
    @GetMapping("/findAllAdmin/{pageNum}")
    public RespBean<PageInfo<Admin>> findAllAdmin(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Admin> adminPageInfo = adminService.findAllAdmin(pageNum);
        return RespBean.success(adminPageInfo);
    }

    /**
     * 添加                ============已测，没问题=====
     *
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin/{id}")
    public RespBean<Admin> addAdmin(@PathVariable("id") Integer id, Admin admin) {
        if (id != 111111) {
            return RespBean.userlmt();
        }
        Integer maxId = adminService.getMaxId();
        Integer admId = maxId + 1;
        admin.setAdmId(admId);
        int i = adminService.addAdmin(admin);
        if (i > 0) {
            return RespBean.success(admin);
        }
        return RespBean.faild();
    }

    /**
     * ============已测，没问题=====
     *
     * @param admId
     * @return
     */
    @DeleteMapping("/deleteAdmin/{id}/{admId}")
    public RespBean<Integer> deleteAdmin(@PathVariable("id") Integer id, @PathVariable("admId") int admId) {
        if (id != 111111) {
            return RespBean.userlmt();
        }
        int i = adminService.deleteAdmin(admId);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }


    /**
     * 修改密码
     * =============== 已测，没问题 =======
     *
     * @param id        操作者
     * @param admId     操作对象id
     * @param oldPasswd 旧密码
     * @param newPasswd 新密码
     * @return
     */
    @PutMapping("/updatePasswd")
    public RespBean<Integer> updatePasswd(Integer id, int admId, String oldPasswd, String newPasswd) {
        if (111111 != id) {
            return RespBean.userlmt();
        }
        int i = adminService.updatePasswd(admId, oldPasswd, newPasswd);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }


    @RequestMapping("/loginOut")
    public RespBean<Integer> loginOut(Token token) {
        int i = tokenService.deleteById(token.getToken());
        if (i > 0) {
            return RespBean.success();
        }
        return RespBean.faild();


    }


    @PutMapping("/update")
    public RespBean<Integer> update(Admin admin) {


        int i = adminService.update(admin);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();

    }

}