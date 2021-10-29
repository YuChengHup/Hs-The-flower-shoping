package com.hs.interceptor;


import com.hs.entity.Token;
import com.hs.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登陆注册直接放行
        List<String> tokenList = Arrays.asList("/end/admin/login", "/end/consumer/login", "/end/consumer/register");
        String uri = request.getRequestURI();
        if (tokenList.contains(uri)) {
            return true;
        }

        String token = request.getHeader("token");

        if (token == null) {

            return false;
        } else {
            // 验证token是否存在
            Token token1 = tokenMapper.queryById(token);
            if (token1 != null) {

                response.setHeader("token", token);
                request.setAttribute("token",token);
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
