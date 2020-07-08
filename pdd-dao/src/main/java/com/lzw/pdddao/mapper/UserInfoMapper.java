package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by lzw on 2020/6/4
 */
@Component
@Mapper
public interface UserInfoMapper {
    UserInfo selectUserInfoByOpenId(String openId);

    String isSaveByOpenId(String openId);

    Integer insertOpenId(String openId);

    Integer updateUserInfo(UserInfo userInfo,String openId);

}
