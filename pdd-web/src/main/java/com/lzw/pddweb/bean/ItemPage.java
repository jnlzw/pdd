package com.lzw.pddweb.bean;

import com.lzw.pdddao.entity.ItemInfo;
import com.lzw.pdddao.model.ItemSimpleInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by lzw on 2020/6/7
 */
@Data
public class ItemPage {
    private ItemInfo itemInfo;
    private List<ItemSimpleInfo> itemSimpleInfos;//同类产品
}
