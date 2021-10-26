package com.hs.service;

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

    /**
     * 通过ID查询单条数据
     *
     * @param admId 主键
     * @return 实例对象
     */
    Admin queryById(Integer admId,String passwd);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
//    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
//    Admin insert(Admin admin);


    /**
     * 通过主键删除数据
     *
     * @param admId 主键
     * @return 是否成功
     */
//    boolean deleteById(Integer admId);

    /**
     * 查询一个byId
     */
//    Admin findAdminById(int admId);

    /**
     * 通过id查token
     */
    Token findToken(int admId);

    /**
     * 查询所有管理员
     */
    List<Admin> findAllAdmin();

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