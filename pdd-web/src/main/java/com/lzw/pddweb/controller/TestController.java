package com.lzw.pddweb.controller;

import com.lzw.pdddao.entity.UserInfo;
import com.lzw.pdddao.mapper.UserInfoMapper;
import com.lzw.pddweb.annotation.ValidationParam;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lzw on 2020/6/26
 */
@RestController
@RequestMapping("api")
public class TestController {
    @Autowired
    UserInfoMapper userInfoMapper;

    @GetMapping("/test1/test11")
    public Result testRole11(HttpServletRequest request){
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/test1/test12")
    public Result testRole12(HttpServletRequest request){
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/test2/test21")
    public Result testRole21(HttpServletRequest request){
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/test2/test22")
    public Result testRole22(HttpServletRequest request){
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/test/login")
    @ValidationParam(value = "openId")
    public Result testRoleLogin(HttpServletRequest request, String openId){
        HttpSession session=request.getSession();
        UserInfo userInfo=userInfoMapper.selectUserInfoByOpenId(openId);
        session.setAttribute("openId",userInfo.getOpenId());
        return RetResponse.makeOKRsp(userInfo);
    }
}
