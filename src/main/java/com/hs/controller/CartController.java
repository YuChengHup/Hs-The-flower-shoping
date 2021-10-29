package com.hs.controller;

import com.hs.entity.Cart;
import com.hs.entity.CartVO;
import com.hs.service.CartService;
import com.hs.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@RestController
@RequestMapping("/end/cart")
public class CartController {
    /**
     * 服务对象
     */
    @Autowired
    private CartService cartService;

    /**
     * 将商品添加进购物车
     * @param cart
     * @return
     */
    @PostMapping("/addCart")
     public RespBean<Integer> insertCart(Cart cart){
        cart.setGmtModified(LocalDateTime.now());
        cart.setGmtCreate(LocalDateTime.now());

         int i = cartService.insert(cart);
         if (i>0){
             return RespBean.success(i);
         }

         return RespBean.faild();
     }


    /**
     * 通过conId查询购物车信息，多表查询
     * @param conId
     * @return
     */
    @RequestMapping("/findCommodity")
    public RespBean<List<CartVO>> findCommodity(Integer conId) {
        List<CartVO> commodity = cartService.findCommodity(conId);
        return RespBean.success(commodity);
    }


    /**
     * 通过主键删除购物车信息
     * @param carId
     * @return
     */
    @RequestMapping("/deleteCart")
    public RespBean<Boolean> deleteCart(Integer carId){
        boolean b = cartService.deleteById(carId);
        if (b==true){
            return RespBean.success();
        }

        return RespBean.faild();
    }

}