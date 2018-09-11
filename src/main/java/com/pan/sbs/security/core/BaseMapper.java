package com.pan.sbs.security.core;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName BaseMapper
 * @Description mapper 基类
 * @Author pzg
 * @Date 2018/9/7 上午9:21
 * @Version 0.0.1
 * @Remark
 **/
public interface BaseMapper<T> extends Mapper<T> , MySqlMapper<T> , ExampleMapper<T>, tk.mybatis.mapper.common.BaseMapper<T> {
}
