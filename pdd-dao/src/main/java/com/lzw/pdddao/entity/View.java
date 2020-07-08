package com.lzw.pdddao.entity;

import lombok.Data;

/**
 * Created by lzw on 2020/6/8
 */
@Data
public class View {
    private String openId;
    private Integer itemId;

    public View(String openId, Integer itemId) {
        this.openId = openId;
        this.itemId = itemId;
    }
}
