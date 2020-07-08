package com.lzw.pddservice.service;

import com.lzw.pdddao.entity.UserInfo;
import com.lzw.pdddao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzw on 2020/6/4
 */
@Service
public class TestService {
    @Autowired
    UserInfoMapper userInfoMapper;


    public UserInfo testService(){
        return userInfoMapper.selectUserInfoByOpenId("1");
    }
}
