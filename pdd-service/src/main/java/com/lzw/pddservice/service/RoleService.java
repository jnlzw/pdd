package com.lzw.pddservice.service;

import com.lzw.pdddao.entity.Apis;
import com.lzw.pdddao.mapper.RoleMapper;
import com.lzw.pdddao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzw on 2020/6/26
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<String> getPowerByRoleName(String openId) {
        List<String> apis = new ArrayList<>();
        String roleName=userInfoMapper.selectUserInfoByOpenId(openId).getRoleName();
        List<Integer> apiIdList = roleMapper.getApisId(roleName);
        for (Integer apiId : apiIdList) {
            apis.add("/api"+getApiAllUrlById(apiId));
        }
        List<Integer> disableApisList=roleMapper.getDisableApisId(openId);
        for (Integer apiId : disableApisList) {
            apis.remove("/api"+getApiAllUrlById(apiId));
        }
        return apis;
    }

    private String getApiAllUrlById(Integer apiId){
        Apis api;
        StringBuilder url = new StringBuilder();
        Integer tempId=apiId;
        while (true){
            api = roleMapper.getApiInfoById(tempId);
            url.insert(0, api.getApiUrl());
            tempId=api.getSubId();
            if (tempId==0)break;
        }
        return url.toString();
    }

}
