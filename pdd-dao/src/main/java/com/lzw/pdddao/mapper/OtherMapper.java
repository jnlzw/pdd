package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.View;
import com.lzw.pdddao.model.CollectionInfo;
import com.lzw.pdddao.model.ItemSimpleInfo;
import com.lzw.pdddao.model.ViewInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lzw on 2020/6/8
 */
@Component
@Mapper
public interface OtherMapper {
    public Integer insertView(String openId,Integer itemId);

    public List<ItemSimpleInfo> selectView(String openId);

    public Integer insertCollections(String openId,Integer itemId);

    public List<ItemSimpleInfo> selectCollection(String openId);

}
