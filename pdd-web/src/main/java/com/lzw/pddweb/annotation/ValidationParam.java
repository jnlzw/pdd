package com.lzw.pddweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lzw on 2020/7/5
 */
@Target(ElementType.METHOD)          // 可用在方法的参数上
@Retention(RetentionPolicy.RUNTIME)     // 运行时有效
public @interface ValidationParam {
    String value() default ""; //标记参数信息  用","分割。
}
