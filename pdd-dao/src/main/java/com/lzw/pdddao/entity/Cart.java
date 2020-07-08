package com.lzw.pdddao.entity;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by lzw on 2020/6/8
 */
@Data
public class Cart {
    private String openId;
    private Integer itemId;
    private Integer itemNum;

    public Cart(String openId, Integer itemId) {
        this.openId = openId;
        this.itemId = itemId;
        this.itemNum=1;
    }
}
