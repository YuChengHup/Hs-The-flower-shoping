package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Admin;
import com.hs.entity.Token;
import com.hs.service.AdminService;
import com.hs.service.TokenService;
import com.hs.util.RespBean;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    private static Integer id = 111111;
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;

    /**
     *                                    ============已测，没问题=====
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
     *                        ============已测，没问题=====
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
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public RespBean<Admin> addAdmin(Admin admin) {
        id++;
        admin.setAdmId(id);
        int i = adminService.addAdmin(admin);
        if (i > 0) {
            return RespBean.success(admin);
        }
        return RespBean.faild();
    }

    /**
     *                                      ============已测，没问题=====
     * @param admId
     * @return
     */
    @DeleteMapping("/deleteAdmin/{admId}")
    public RespBean<Integer> deleteAdmin(@PathVariable("admId") int admId) {
        int i = adminService.deleteAdmin(admId);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }


    /**
     * 修改密码
     *                              =============== 已测，没问题 =======
     * @param admId
     * @param oldPasswd
     * @param newPasswd
     * @return
     */
    @PutMapping("/updatePasswd")
    public RespBean<Integer> updatePasswd(int admId, String oldPasswd, String newPasswd) {

        int i = adminService.updatePasswd(admId, oldPasswd, newPasswd);
        if (i > 0) {
            return RespBean.success(i);
        }
        return RespBean.faild();
    }

    @GetMapping("/loginOut")
    public RespBean<Integer> loginOut(Token token) {

        return RespBean.success();

    }

}