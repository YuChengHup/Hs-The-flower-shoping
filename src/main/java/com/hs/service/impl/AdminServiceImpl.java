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
    public Admin queryById(Integer admId,String passwd) {

        Admin admin = adminMapper.queryById(admId);
        if(passwd.equals(admin.getPasswd())){
            return admin;
        }else{
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
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminMapper.insert(admin);
        return admin;
    }


    /**
     * 通过主键删除数据
     *
     * @param admId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer admId) {
        return this.adminMapper.deleteById(admId) > 0;
    }
}