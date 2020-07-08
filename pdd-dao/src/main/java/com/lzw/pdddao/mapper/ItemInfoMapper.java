package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.ItemInfo;
import com.lzw.pdddao.model.ItemSimpleInfo;
import com.lzw.pdddao.model.CartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lzw on 2020/6/7
 */
@Component
@Mapper
public interface ItemInfoMapper {
    public List<ItemSimpleInfo> getSimpleInfo(Integer onset, Integer offset);

    public ItemInfo getItemInfoById(Integer itemId);

    public List<ItemSimpleInfo> getSameItem(Integer itemId,Integer offset);

    public List<CartInfo> getCartInfoByOpenId(String openId);
}
