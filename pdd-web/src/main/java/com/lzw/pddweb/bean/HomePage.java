package com.lzw.pddweb.bean;

import com.lzw.pdddao.model.ItemSimpleInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzw on 2020/6/7
 */
@Data
public class HomePage {
    List<String> imgUrls;
    List<ItemSimpleInfo> itemSimpleInfos;

    public HomePage(){
        this.imgUrls=new ArrayList<>();
        this.itemSimpleInfos=new ArrayList<>();
    }
}
