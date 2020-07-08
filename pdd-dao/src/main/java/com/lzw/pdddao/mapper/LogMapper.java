package com.lzw.pdddao.mapper;

import com.lzw.pdddao.entity.log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by lzw on 2020/6/27
 */
@Component
@Mapper
public interface LogMapper {
    public Integer insertLog(log log);
}
