package com.lzw.pddweb.controller;

import com.lzw.pdddao.mapper.ItemInfoMapper;
import com.lzw.pddweb.bean.HomePage;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by lzw on 2020/6/7
 */
@RestController
@RequestMapping("api")
public class HomePageController {
    @Autowired
    ItemInfoMapper itemInfoMapper;


    @GetMapping("/homepage")
    public Result getHomepage(@NotNull Integer onset, @NotNull Integer offset){
        System.out.println("onset = " + onset);
        System.out.println("offset = " + offset);
        HomePage homePage=new HomePage();
        homePage.getImgUrls().add("https://a4.vimage1.com/upload/flow/2017/10/20/117/15084947982974.jpg");
        homePage.getImgUrls().add("https://img.alicdn.com/tfs/TB1eyCLJbr1gK0jSZFDXXb9yVXa-520-280.png_q90_.webp");
        homePage.getImgUrls().add("https://img11.360buyimg.com/babel/s1900x846_jfs/t1/111703/2/9008/63532/5ed60076Eb84add5b/0e2e68f590ac2a80.jpg!cc_1900x846");
        homePage.getItemSimpleInfos().addAll(itemInfoMapper.getSimpleInfo(onset,offset));
        return RetResponse.makeOKRsp(homePage);
    }
}
