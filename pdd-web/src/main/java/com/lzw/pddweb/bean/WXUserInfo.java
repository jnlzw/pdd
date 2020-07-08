package com.lzw.pddweb.bean;

import lombok.Data;

/**
 * Created by lzw on 2020/6/5
 */
@Data
public class WXUserInfo {
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;
    private String language;
    private String nickName;
    private String province;

    @Override
    public String toString() {
        return "WXUserInfo{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", nickName='" + nickName + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
