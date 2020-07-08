package com.lzw.pdddao.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by lzw on 2020/6/7
 */
@Data
public class ItemInfo {
    private Integer itemId;
    private Integer typeId;
    private String title;
    private String image;
    private Integer height;
    private Integer width;
    private Integer surplus;
    private Integer sales;
    private Integer price;
    private String detailImage;
    private Timestamp createTime;

    @Override
    public String toString() {
        return "ItemDetailInfo{" +
                "itemId=" + itemId +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", surplus=" + surplus +
                ", sales=" + sales +
                ", detailImage=" + detailImage +
                ", createTime=" + createTime +
                '}';
    }
}
