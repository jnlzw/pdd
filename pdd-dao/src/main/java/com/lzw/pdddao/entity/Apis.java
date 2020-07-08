package com.lzw.pdddao.entity;

import lombok.Data;

/**
 * Created by lzw on 2020/6/26
 */
@Data
public class Apis {
    private Integer apiId;
    private Integer subId;
    private String apiUrl;
    private String apiName;
}
