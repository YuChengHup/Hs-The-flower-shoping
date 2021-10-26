package com.hs.controller;

import com.hs.entity.Admin;
import com.hs.entity.Token;
import com.hs.service.AdminService;
import com.hs.service.TokenService;
import com.hs.util.JsonUtil;
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

    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenService tokenService;
    JsonUtil<String> jsonUtil=new JsonUtil<>();
    RespBean respBean=new RespBean();
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

    @RequestMapping("/login")
    public RespBean<Admin> login(Integer admId, String passwd,ServletResponse response) {
        Admin admin = adminService.queryById(admId, passwd);
        System.out.println(admin+"=================");
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

    /**
     * 通过id查找token
     */
    @RequestMapping("/findToken")
    public RespBean<Token> findToken(int admId){
        Token token = adminService.findToken(admId);
        return RespBean.success(token);
    }

    /**
     * 通过token查找id
     */

    /**
     * 查找管理员
     */
//    @RequestMapping("/findByAdmId")
//    public RespBean findByAdmId(int admId){
//        Admin admin = adminService.findAdminById(admId);
//        respBean.setData(admin);
//        return respBean;
//    }

    /**
     * 管理员列表
     */
    @RequestMapping("/findAllAdmin")
    public RespBean findAllAdmin(){
        List<Admin> adminList = adminService.findAllAdmin();
        respBean.setCode(1001);
        respBean.setMessage("搜索成功！");
        respBean.setData(adminList);
        return respBean;
    }

    /**
     * 添加管理员
     */
    @RequestMapping("/addAdmin")
    public RespBean addAdmin(Admin admin){
        int i = adminService.addAdmin(admin);
        if (i>0){
            respBean.setCode(1001);
            respBean.setMessage("添加成功！");
            respBean.setData("√");
            return RespBean.success();
        }
        respBean.setCode(1003);
        respBean.setMessage("添加失败！");
        respBean.setData("×");
        return respBean;
    }

    /**
     * 删除管理员
     */
    @RequestMapping("/deleteAdmin")
    public RespBean deleteAdmin(int admId){
        int i = adminService.deleteAdmin(admId);
        if (i>0){
            respBean.setCode(1001);
            respBean.setMessage("删除成功！");
            respBean.setData("√");
            return respBean;
        }
        respBean.setCode(1003);
        respBean.setMessage("删除失败！");
        respBean.setData("×");
        return respBean;
    }



    /**
     * 修改密码
     * @param admId
     * @param oldPasswd
     * @param newPasswd
     * @return
     */
    @RequestMapping("/updatePasswd")
    public RespBean updatePasswd(int admId, String oldPasswd, String newPasswd) {
            
        int i = adminService.updatePasswd(admId, oldPasswd, newPasswd);

            if(i == 0) {
                respBean.setCode(1002);
                respBean.setMessage("老密码错误！");
                respBean.setData(newPasswd);
                return respBean;
            }
            if (i == 1) {
                respBean.setCode(1001);
                respBean.setMessage("修改成功!");
                respBean.setData(newPasswd);
                return respBean;
            }
        if (i==3){
                respBean.setCode(1000);
                respBean.setMessage("新旧密码不能相同!");
                respBean.setData(newPasswd);
                return respBean;
            }
        return respBean;
    }
    @GetMapping("/loginOut")
    public RespBean loginOut(Token token) {
        int i = tokenService.deleteById(token.getToken());
        if (i>0){
            respBean.setCode(1001);
            respBean.setMessage("退出成功!");
            respBean.setData("√");
            return respBean;
        }
        respBean.setCode(1003);
        respBean.setMessage("退出失败!");
        respBean.setData("×");
        return respBean;

    }

}