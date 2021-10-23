package com.hs.service;

import com.hs.entity.Token;

import java.util.List;

/**
 * (Token)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface TokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param token 主键
     * @return 实例对象
     */
    Token queryById(String token);

    /**
     * 插入数据
     * @param token 对象
     * @return int
     */
    int insert(Token token);

    /**
     * 通过主键删除数据
     *
     * @param token 主键
     * @return 是否成功
     */
    int deleteById(String token);

}