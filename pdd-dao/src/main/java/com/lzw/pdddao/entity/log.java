package com.lzw.pdddao.entity;

import lombok.Data;

/**
 * Created by lzw on 2020/6/27
 */
@Data
public class log {
    private String openId;
    private String ip;
    private String url;
    private String args;
    private Integer code;
    private String result;

    public log(String openId, String ip, String url, String args, Integer code, String result) {
        this.openId = openId;
        this.ip = ip;
        this.url = url;
        this.args = args;
        this.code = code;
        this.result = result;
    }
}
