package com.lzw.pddweb.controller;

import com.lzw.pdddao.entity.UserInfo;
import com.lzw.pddservice.service.LoginService;
import com.lzw.pddservice.service.WXService;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lzw.pddweb.bean.WXUserInfo;
/**
 * Created by lzw on 2020/6/4
 */
@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    WXService wxService;
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Result login(@NotNull String code){
        String openId=wxService.getOpenIdByCode(code);
        System.out.println(openId);
        String session=loginService.getSessionByOpenId(openId);
        System.out.println("session="+session);
        return RetResponse.makeOKRsp().setMsg("已得到openid").setData(session);
    }

    @GetMapping("/put_userinfo")
    public Result putUserInfo(UserInfo userInfo, String session){
        loginService.updateUserInfo(session,userInfo);
        return RetResponse.makeOKRsp().setMsg("已得到userinfo");
    }

}
