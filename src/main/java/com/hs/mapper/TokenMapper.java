package com.hs.mapper;

import com.hs.entity.Token;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Token)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
public interface TokenMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param token 主键
     * @return 实例对象
     */
    Token queryById(String token);


    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int insert(Token token);



    /**
     * 通过主键删除数据
     *
     * @param token 主键
     * @return 影响行数
     */
    int deleteById(String token);

}