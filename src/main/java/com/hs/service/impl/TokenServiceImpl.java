package com.hs.service.impl;

import com.hs.entity.Token;
import com.hs.mapper.TokenMapper;
import com.hs.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Token)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenMapper tokenMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param token 主键
     * @return 实例对象
     */
    @Override
    public Token queryById(String token) {
        return tokenMapper.queryById(token);
    }

    @Override
    public int insert(Token token) {
        return tokenMapper.insert(token);
    }

    /**
     * 通过主键删除数据
     *
     * @param token 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String token) {
        return tokenMapper.deleteById(token) ;
    }
}