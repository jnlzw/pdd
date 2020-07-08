package com.lzw.pddservice.service;

import cn.hutool.core.util.IdUtil;
import com.lzw.pdddao.entity.UserInfo;
import com.lzw.pdddao.mapper.UserInfoMapper;
import com.lzw.pdddao.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzw on 2020/6/5
 */
@Service
public class LoginService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserInfoMapper userInfoMapper;

    //每次登陆获取新的session
    public String getSessionByOpenId(String openid) {
        if (userInfoMapper.isSaveByOpenId(openid).equals("0")) userInfoMapper.insertOpenId(openid);
        String session = IdUtil.simpleUUID();
        redisUtils.set(session, openid);
        return session;
    }

    public boolean updateUserInfo(String session, UserInfo userInfo){
        String openid=redisUtils.get(session);
        System.out.println("openid = " + openid);
        userInfoMapper.updateUserInfo(userInfo,openid);
        return true;
    }
}
