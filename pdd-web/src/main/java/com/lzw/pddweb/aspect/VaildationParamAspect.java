package com.lzw.pddweb.aspect;

import com.lzw.pddweb.annotation.ValidationParam;
import com.lzw.pddweb.controller.TestController;
import com.lzw.pddweb.result.Result;
import com.lzw.pddweb.result.RetResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzw on 2020/7/5
 * 参数检验切片
 */
@Aspect
@Component
@Order(1)
public class VaildationParamAspect {
    //TestController.testRoleLogin
    @Pointcut("execution(public * com.lzw.pddweb.controller.TestController.testRoleLogin(..)))")
    public void brokerAspect() {
    }


    @Around(value = "brokerAspect()")
    public Object vaildationParamAspect(ProceedingJoinPoint pjp) {
        try {
            MethodSignature sign = (MethodSignature) pjp.getSignature();
            Method method = sign.getMethod();
            ValidationParam annotation = method.getAnnotation(ValidationParam.class);
            ArrayList<String> paraNeed = new ArrayList<>();//所需参数列表
            Arrays.stream(annotation.value().split(",")).forEach(o1 -> paraNeed.add(o1.trim()));
            if(getParaByName(pjp, paraNeed)) return RetResponse.makeErrRsp("缺少参数");
            Object[] args = pjp.getArgs();
            return pjp.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    //判断参数名是否有对应参数
    private boolean getParaByName(ProceedingJoinPoint pjp, List<String> paraNeed) {
        Object[] args = pjp.getArgs();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        List<String> parameterNames = Arrays.asList(methodSignature.getParameterNames());
        for (String para : paraNeed) {
            int index = parameterNames.indexOf(para);
            if (index == -1) return true;//没有该参数
            if (args[index]==null)return true;//参数为null
        }
        return false;
    }

}
