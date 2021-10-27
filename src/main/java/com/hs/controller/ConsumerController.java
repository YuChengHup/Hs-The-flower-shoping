package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Admin;
import com.hs.entity.Consumer;
import com.hs.entity.Token;
import com.hs.service.ConsumerService;
import com.hs.service.TokenService;
import com.hs.util.RespBean;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Consumer)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/consumer")
public class ConsumerController {
    /**
     * 服务对象
     */
    @Autowired
    private ConsumerService consumerService;

    @Resource
    private TokenService tokenService;

    /**
     *登录
     */
    @RequestMapping("login")
    public RespBean<String> login(Consumer consumer, ServletResponse response){
        int i = consumerService.login(consumer);
        RespBean<String> resp=new RespBean<>();
        if (i==1){
            resp.setData("用户名不存在");
        }else if (i==3){
            resp.setData("该用户被冻结");
        }else if (i==0){
            resp.setData("密码错误");
        }else if (i==2){
        resp.setData("登录成功");
        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setConId(consumer.getConId());
        token.setIsLogin(1);
        tokenService.insert(token);
        HttpServletResponse resp1 = (HttpServletResponse)response ;
        resp1.setHeader("token", token.getToken());
        }
        return resp;
    }
    /**
     * 退出登录
     */
    @GetMapping("/loginout")
    public RespBean<String> login(Integer conId, HttpSession session) {
        int i = tokenService.deleteByConId(conId);
        RespBean<String> resp=new RespBean();
        if (i==1){
            resp.setData("已退出登录");
            session.invalidate();
        }else {
            resp.setData("退出登录失败");
        }
        return resp;
    }

    /**
     * 修改密码
     */
    @RequestMapping("uppasswd")
    public RespBean<String> upPasswd(Consumer consumer,String passwd2){
        int i = consumerService.upPasswd(consumer, passwd2);
        RespBean<String> resp=new RespBean<>();
        if (i==2){
            resp.setCode(201);
            resp.setData("旧密码错误");
            return resp;
        }else if (i==0) {
            resp.setCode(202);
            resp.setData("修改密码失败");
            return resp;
        }
        resp.setCode(200);
        resp.setData("修改密码成功");
        return resp;
    }


    /**
     * 通过主键查询单条数据
     *
     * @param consumer
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public RespBean<Consumer> selectOne(Consumer consumer) {
        RespBean<Consumer> respBean=new RespBean<>();
        Consumer consumer1 = consumerService.queryById(consumer);
        if (consumer1!=null){
            respBean.setCode(200);
            respBean.setMessage("ok");
            respBean.setData(consumer1);
        }else {
            respBean.setCode(201);
            respBean.setMessage("ok");
        }
        return respBean;
    }


    @RequestMapping("/findAll")
    public RespBean<PageInfo<Consumer>> findAll(int pageNum,int pageSize){
        return RespBean.success(consumerService.findAll(pageNum,pageSize));
    }

    @RequestMapping("/findDeleteAll")
    public RespBean<PageInfo<Consumer>> findDeleteAll(int pageNum,int pageSize){
        return RespBean.success(consumerService.findDeleteAll(pageNum,pageSize));
    }


    /**
     * 多条件模糊查询
     */
    @RequestMapping("/queryAll")
    public RespBean<PageInfo<Consumer>> queryAll(int pageNum,int pageSize,Consumer consumer){
        return RespBean.success(consumerService.queryAll(pageNum,pageSize,consumer));
    }

    @RequestMapping("/insert")
    public RespBean<Consumer> insertCustomer(Consumer consumer){
        consumer.setGmtCreate(LocalDateTime.now());
        consumer.setGmtModified(LocalDateTime.now());
        consumer.setConStatus(0);
        RespBean<Consumer> resp=new RespBean<>();
        Consumer consumer1 = consumerService.insert(consumer);
        if (consumer1!=null){
            resp.setCode(200);
            resp.setMessage("注册成功");
            resp.setData(consumer1);
        }else{
            resp.setCode(201);
            resp.setMessage("注册失败");
        }
        return resp;
    }

    @RequestMapping("/addCustomer")
    public RespBean<String> addCustomer(Consumer consumer){
        consumer.setGmtCreate(LocalDateTime.now());
        consumer.setGmtModified(LocalDateTime.now());
        consumer.setConStatus(0);

        RespBean<String> respBean=new RespBean<>();
        int i = consumerService.addConsumer(consumer);

        if (i>0){
            respBean.setCode(1001);
            respBean.setMessage("添加成功");
            respBean.setData("添加成功");
            return respBean;
        }

        respBean.setCode(1002);
        respBean.setMessage("添加失败");
        respBean.setData("添加失败");
        return respBean;
    }

    /**
     * 通过用户名查找客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/findConsumerByUsername")
    public RespBean<List<Consumer>> queryConsumerByUsername(Consumer consumer){
        List<Consumer> consumers = consumerService.queryConsumerByUsername(consumer);
        if (consumers!=null){
            return RespBean.success(consumers);
        }
        return RespBean.faild();
    }

    /**
     * 通过主键删除客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/deleteById")
    public RespBean<Integer> deleteById(Consumer consumer){
        return RespBean.success(consumerService.deleteById(consumer));
    }

    /**
     * 通过id修改状态,假删除
     * @param consumer
     * @return
     */
    @RequestMapping("/updateById")
    public RespBean<Integer> updateById(Consumer consumer){
        return RespBean.success(consumerService.update(consumer));
    }

    /**
     * 通过id查询单条客户信息
     * @param consumer
     * @return
     */
    @RequestMapping("/findById")
    public RespBean<Consumer> findById(Consumer consumer){
        return RespBean.success(consumerService.findById(consumer));
    }


    @GetMapping("/query_num")
    public RespBean<Long> queryNum(){
        return RespBean.success(consumerService.queryNum());
    }
}