package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Admin;
import com.hs.entity.Token;
import com.hs.mapper.AdminMapper;
import com.hs.mapper.TokenMapper;
import com.hs.service.AdminService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 通过ID查询单条数据,登录
     *
     * @param admId 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer admId, String passwd) {

        Admin admin = adminMapper.queryById(admId, passwd);
        if (admin == null) {
            return null;
        }
        if (passwd.equals(admin.getPasswd())) {
            return admin;
        } else {
            return null;
        }
    }


    /**
     * 查询所有管理员
     */
    @Override
    public PageInfo<Admin> findAllAdmin(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> adminList = adminMapper.findAllAdmin();
        return new PageInfo<>(adminList);
    }

    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    /**
     * 删除管理员
     */
    @Override
    public int deleteAdmin(int admId) {
        return adminMapper.deleteAdmin(admId);
    }

    /**
     * 修改密码
     *
     * @param admId
     * @param oldPasswd
     * @param newPasswd
     * @return
     */
    @Override
    public int updatePasswd(int admId, String oldPasswd, String newPasswd) {
        Admin admin = adminMapper.findOldPasswdByAdmId(admId);

        if (!admin.getPasswd().equals(oldPasswd)) {
//              老密码错误
            return -1;
        } else {
            if (oldPasswd.equals(newPasswd)) {
                return -2;
            } else {
                return adminMapper.updatePasswd(newPasswd, admId);
            }

        }
    }
}