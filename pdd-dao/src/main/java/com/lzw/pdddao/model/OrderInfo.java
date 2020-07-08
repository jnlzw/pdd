package com.lzw.pdddao.model;

import lombok.Data;

/**
 * Created by lzw on 2020/6/9
 */
@Data
public class OrderInfo {
    private Integer orderId;
    private String title;
    private String image;
    private Integer price;
    private Integer itemNum;
    private Integer sta;
}
