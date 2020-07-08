package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by lzw on 2020/6/8
 */
@Component
@Mapper
public interface CartMapper {
    public Cart selectCart(String openId,Integer itemId);

    public Integer insertCart(String openId,Integer itemId);

    public Integer incItemNum(String openId,Integer itemId);

    public Integer decItemNum(String openId,Integer itemId);

    public Integer delateCart(String openId,Integer itemId);
}
