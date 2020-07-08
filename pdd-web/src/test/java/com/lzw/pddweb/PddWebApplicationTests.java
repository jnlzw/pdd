package com.lzw.pddweb;

import com.lzw.pdddao.entity.log;
import com.lzw.pdddao.mapper.*;
import com.lzw.pddservice.service.RoleService;
import com.lzw.pddservice.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class PddWebApplicationTests {

    @Autowired
    TestService testService;
    @Autowired
    ItemInfoMapper itemInfoMapper;
    @Autowired
    OtherMapper otherMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    LogMapper logMapper;

    @Test
    void contextLoads() {
    }

}
