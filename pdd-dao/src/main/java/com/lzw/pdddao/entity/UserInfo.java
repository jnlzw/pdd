package com.lzw.pdddao.entity;

import lombok.Data;

import java.sql.Date;

/**
 * Created by lzw on 2020/6/4
 */
@Data
public class UserInfo {
    private String openId;
    private String nickName;
    private Date createTime;
    private String avatarUrl;
    private String city;
    private String country;
    private String province;
    private Integer gender;
    private String language;
    private String roleName;

    @Override
    public String toString() {
        return "UserInfo{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", createTime=" + createTime +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                '}';
    }
}
