package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.Apis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lzw on 2020/6/26
 */
@Component
@Mapper
public interface RoleMapper {
    //查询角色
    public List<Integer> getApisId(String roleName);

    //获取api的url
    public Apis getApiInfoById(Integer apiId);

    //获取禁用列表
    public List<Integer> getDisableApisId(String openId);
}
