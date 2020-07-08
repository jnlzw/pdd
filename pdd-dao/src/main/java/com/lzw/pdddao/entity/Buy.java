package com.lzw.pdddao.entity;

import lombok.Data;

/**
 * Created by lzw on 2020/6/8
 */
@Data
public class Buy {
    private String openId;
    private Integer itemId;
    private Integer itemNum;
    private Integer sta;//状态 1表示待完成 2表示已完成 3表示删除

    public Buy(String openId, Integer itemId, Integer itemNum) {
        this.openId = openId;
        this.itemId = itemId;
        this.itemNum = itemNum;
        this.sta=1;
    }
}
