package com.dj.user.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * Created by dajiechen on 2017/8/3.
 */
public interface BaseMapper <T> extends Mapper<T>, MySqlMapper<T>{
}
