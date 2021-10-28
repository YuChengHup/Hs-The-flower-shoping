package com.hs.mapper;

import com.hs.entity.Admin;
import com.hs.entity.Token;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface AdminMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param admId 主键
     * @return 实例对象
     */
    Admin queryById(@Param("admId") int admId,@Param("passwd") String passwd);


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
    int deleteAdmin(int adm_id);

    /**
     * 通过id查询老密码
     */
    Admin findOldPasswdByAdmId(int admId);

    /**
     * 修改密码
     */
    int updatePasswd(@Param("passwd") String newPasswd,@Param("admId") int admId);


    Integer getMaxId();



    int update(Admin admin);

}