package com.lzw.pddweb.controller;

import com.lzw.pdddao.mapper.CartMapper;
import com.lzw.pdddao.mapper.OrderMapper;
import com.lzw.pdddao.redis.RedisUtils;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzw on 2020/6/8
 */
@RestController
@RequestMapping("api")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CartMapper cartMapper;

    @GetMapping("/order/add")
    public Result addOrder(String session,Integer itemId){
        String openid=redisUtils.get(session);
        orderMapper.insertOrder(openid,itemId,1);
        return RetResponse.makeOKRsp("添加单个订单");
    }

    @GetMapping("/order/get")
    public Result getOrder(String session,Integer sta){
        String openid=redisUtils.get(session);
        return RetResponse.makeOKRsp(orderMapper.selectOrderInfo(openid,sta));
    }

    @GetMapping("/order/fin")
    public Result getOrder(Integer orderId){
        orderMapper.finOrder(orderId);
        return RetResponse.makeOKRsp("已完成订单");
    }

    @GetMapping("/order/add_all")
    public Result addAllOrder(String session,String orderStr){
        String openid=redisUtils.get(session);
        System.out.println("orderStr = " + orderStr);
        if (orderStr.length()>1){
            String[]items=orderStr.split("-");
            for (String item:items) {
                String[] info=item.split("_");
                System.out.println("info[0] = " + info[0]);//0是id 1是num
                orderMapper.insertOrder(openid,Integer.parseInt(info[0]),Integer.parseInt(info[1]));
                cartMapper.delateCart(openid,Integer.parseInt(info[0]));
            }
        }
        return RetResponse.makeOKRsp("购买成功");
    }


}
