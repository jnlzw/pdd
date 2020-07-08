package com.lzw.pdddao.model;

import lombok.Data;

/**
 * Created by lzw on 2020/6/7
 */
@Data
public class ItemSimpleInfo {
    private Integer itemId;
    private String title;
    private String image;
    private Integer height;
    private Integer width;

    @Override
    public String toString() {
        return "ItemSimpleInfo{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
