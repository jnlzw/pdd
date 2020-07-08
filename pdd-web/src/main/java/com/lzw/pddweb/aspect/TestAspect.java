package com.lzw.pddweb.aspect;

import com.lzw.pdddao.entity.log;
import com.lzw.pdddao.mapper.LogMapper;
import com.lzw.pddservice.service.RoleService;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 权限检验和日志切片
 */
@Aspect
@Component
@Order(2)
public class TestAspect {
    //TestController
    @Pointcut("execution(public * com.lzw.pddweb.controller.TestController.*(..)))")
    public void BrokerAspect() {
    }

    @Autowired
    RoleService roleService;
    @Autowired
    LogMapper logMapper;


    @Around(value = "BrokerAspect()")
    //环绕通知完成权限检验
    public Object aroundAOP(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            HttpServletRequest request=(HttpServletRequest)args[0];
            String url=request.getRequestURI();
            if (url.equals("/api/test/login"))return pjp.proceed(args); //登录接口放行
            String openId=(String)request.getSession().getAttribute("openId");
            if (null==openId)return RetResponse.makeErrRsp("请先登录"); //没有session信息 拦截
            List<String>powerList= roleService.getPowerByRoleName(openId);
            boolean flag=false;
            for (String powerUrl:powerList)if (powerUrl.equals(url))flag=true;
            if (!flag) return RetResponse.makeErrRsp("没有权限");
            return pjp.proceed(args); //有权限放行
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning(value = "BrokerAspect()", returning="result")
    public void afterReturningAOP(JoinPoint joinPoint, Result result){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        HttpServletRequest request=(HttpServletRequest) joinPoint.getArgs()[0];
        String IP=getIpAddress(request);
        String openId=(String) request.getSession().getAttribute("openId");
        String url=request.getRequestURI();
        StringBuilder args=new StringBuilder();
        //记录除了request的参数
        Arrays.stream(joinPoint.getArgs()).forEach(o1->{ if (!(o1 instanceof ServletRequest))args.append(o1).append("\n");});
        args.delete(args.length()-1,args.length());
        //请求信息存入数据库
        log log=new log(openId,IP,url,args.toString(),result.getCode(),result.toString());
        logMapper.insertLog(log);
        /*
        System.out.println("************************************************************************");
        System.out.println("日志系统");
        System.out.println("openId= "+ openId);
        System.out.println("IP= "+IP);
        System.out.println("方法名 = " + methodName);
        System.out.println("路径 = " + url);
        System.out.println("参数："+args);
        System.out.println("结果 = " + result.toString());
         */
    }

    private  String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip+":"+request.getRemotePort();
    }
}