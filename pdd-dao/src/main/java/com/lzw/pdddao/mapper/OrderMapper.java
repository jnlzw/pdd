package com.lzw.pdddao.mapper;

import com.lzw.pdddao.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lzw on 2020/6/8
 */
@Component
@Mapper
public interface OrderMapper {
    public Integer insertOrder(String openId,Integer itemId,Integer itemNum);

    public Integer updateOrder(Integer orderId);

    public List<OrderInfo> selectOrderInfo(String openId, Integer sta);

    public Integer finOrder(Integer orderId);
}
