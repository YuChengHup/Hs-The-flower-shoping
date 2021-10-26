package com.hs.service.impl;

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
//    @Override
//    public List<Admin> queryAllByLimit(int offset, int limit) {
//        return this.adminMapper.queryAllByLimit(offset, limit);
//    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
//    @Override
//    public Admin insert(Admin admin) {
//        this.adminMapper.insert(admin);
//        return admin;
//    }


    /**
     * 通过主键删除数据
     *
     * @param admId 主键
     * @return 是否成功
     */
//    @Override
//    public boolean deleteById(Integer admId) {
//        return this.adminMapper.deleteById(admId) > 0;
//    }

    /**
     * 查询一个byId
     * @param admId
     * @return
     */
//    @Override
//    public Admin findAdminById(int admId) {
//        return adminMapper.queryById(admId);
//    }

    /**
     * 通过id查找token
     *
     * @param admId
     * @return
     */
    @Override
    public Token findToken(int admId) {
        return adminMapper.findToken(admId);
    }

    /**
     * 查询所有管理员
     */
    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin();
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
    public int deleteAdmin(int adm_id) {
        return adminMapper.deleteAdmin(adm_id);
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
//        if (!admin.getAdmId().equals(admId)) {
////            账户错误
//            return 2;
//        } else {
            if (!admin.getPasswd().equals(oldPasswd)) {
//              老密码错误
                return 0;
            }else {
                if (oldPasswd.equals(newPasswd)){
                    return 3;
                }else {
                    int i = adminMapper.updatePasswd(newPasswd, admId);
                    return i;
                }



        }

//        if (i>0){
////            修改成功
//            return 1;
//        }
////        修改失败
//        return 3;
//    }

    }
}