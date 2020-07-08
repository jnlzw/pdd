package com.lzw.pddservice.bean;

import org.springframework.context.annotation.Bean;

/**
 * Created by lzw on 2020/6/3
 */

public class TestBean {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
