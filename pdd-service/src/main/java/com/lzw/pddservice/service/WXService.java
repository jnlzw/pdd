package com.lzw.pddservice.service;

import com.alibaba.fastjson.JSONObject;
import com.lzw.pdddao.entity.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2020/6/5
 */
@Service
public class WXService {
    public String getOpenIdByCode(String Code){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("appid", "wxdb2ac952ddbdabc5");
        map.add("secret", "8c117aa8296a5fd60dad6a425fabe49c");
        map.add("js_code", Code);
        map.add("grant_type", "authorization_code");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class);
        JSONObject returnJson = JSONObject.parseObject(response.getBody());
        return returnJson.get("openid").toString();
    }

}
