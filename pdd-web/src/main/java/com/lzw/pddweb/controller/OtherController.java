package com.lzw.pddweb.controller;

import com.lzw.pdddao.entity.UserInfo;
import com.lzw.pdddao.mapper.OtherMapper;
import com.lzw.pdddao.model.ItemSimpleInfo;
import com.lzw.pdddao.redis.RedisUtils;
import com.lzw.pddservice.bean.TestBean;
import com.lzw.pddservice.service.TestService;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by lzw on 2020/6/3
 */
@RestController
@RequestMapping("api")
public class OtherController {
    @Autowired
    TestService testService;
    @Autowired
    OtherMapper otherMapper;
    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/test")
    public Result printUser(HttpServletRequest request) {
        return RetResponse.makeOKRsp();
    }

    @GetMapping("/view/add")
    public Result addView(String session,Integer itemId){
        String openid=redisUtils.get(session);
        otherMapper.insertView(openid,itemId);
        return RetResponse.makeOKRsp("添加浏览记录");
    }

    @GetMapping("/collection/add")
    public Result addCollection(String session,Integer itemId){
        String openid=redisUtils.get(session);
        otherMapper.insertCollections(openid,itemId);
        return RetResponse.makeOKRsp("添加收藏");
    }

    @GetMapping("/collection/all")
    public Result allCollection(String session){
        String openid=redisUtils.get(session);
        List ans=otherMapper.selectCollection(openid);
        Collections.reverse(ans);
        Set<ItemSimpleInfo> set=new LinkedHashSet<>(ans);
        return RetResponse.makeOKRsp(set);
    }

    @GetMapping("/view/all")
    public Result allView(String session){
        String openid=redisUtils.get(session);
        List ans=otherMapper.selectView(openid);
        Collections.reverse(ans);
        Set<ItemSimpleInfo> set=new LinkedHashSet<>(ans);
        return RetResponse.makeOKRsp(set);
    }
}
