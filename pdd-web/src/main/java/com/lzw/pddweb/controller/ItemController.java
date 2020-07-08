package com.lzw.pddweb.controller;

import com.lzw.pdddao.entity.Cart;
import com.lzw.pdddao.mapper.CartMapper;
import com.lzw.pdddao.mapper.ItemInfoMapper;
import com.lzw.pdddao.model.CartInfo;
import com.lzw.pdddao.redis.RedisUtils;
import com.lzw.pddweb.bean.ItemPage;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzw on 2020/6/7
 */
@RestController
@RequestMapping("api")
public class ItemController {
    @Autowired
    ItemInfoMapper itemInfoMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CartMapper cartMapper;

    @GetMapping("/item/select")
    public Result selectItemInfo(@NotNull Integer itemId) {
        ItemPage itemPage = new ItemPage();
        itemPage.setItemInfo(itemInfoMapper.getItemInfoById(itemId));
        itemPage.setItemSimpleInfos(new ArrayList<>(itemInfoMapper.getSameItem(itemId, 4)));
        return RetResponse.makeOKRsp(itemPage);
    }

    @GetMapping("/cart/get")
    public Result getCart(@NotNull String session) {
        String openid = redisUtils.get(session);
        List<CartInfo> carts = new ArrayList<>(itemInfoMapper.getCartInfoByOpenId(openid));
        return RetResponse.makeOKRsp(carts);
    }

    @GetMapping("/cart/add")
    public Result addCart(String session, Integer itemId) {
        String openid = redisUtils.get(session);
        Cart cart = cartMapper.selectCart(openid, itemId);
        if (cart == null) cartMapper.insertCart(openid, itemId);
        else cartMapper.incItemNum(openid, itemId);
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/cart/inc")
    public Result incItemNum(String session, Integer itemId) {
        String openid = redisUtils.get(session);
        cartMapper.incItemNum(openid, itemId);
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/cart/dec")
    public Result decItemNum(String session, Integer itemId) {
        String openid = redisUtils.get(session);
        cartMapper.decItemNum(openid, itemId);
        return RetResponse.makeOKRsp();
    }


}