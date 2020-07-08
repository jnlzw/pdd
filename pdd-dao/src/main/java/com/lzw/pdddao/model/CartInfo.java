package com.lzw.pdddao.model;

import lombok.Data;

/**
 * Created by lzw on 2020/6/8
 */
@Data
public class CartInfo {
    private Integer itemId;
    private String title;
    private String image;
    private Integer itemNum;
    private Integer price;
}
