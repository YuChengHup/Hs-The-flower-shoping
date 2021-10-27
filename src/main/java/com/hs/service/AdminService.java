package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Admin;
import com.hs.entity.Token;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface AdminService {

    Integer pageSize=5;
    /**
     * 通过ID查询单条数据
     *
     * @param admId 主键
     * @return 实例对象
     */
    Admin queryById(Integer admId,String passwd);

    /**
     * 查询所有管理员
     */
    PageInfo<Admin> findAllAdmin(Integer pageNum);

    /**
     * 添加管理员
     */
    int addAdmin(Admin admin);

    /**
     * 删除管理员
     */
    int deleteAdmin(int admId);

    /**
     * 修改密码
     */
    int updatePasswd(int admId,String oldPasswd,String newPasswd);
}