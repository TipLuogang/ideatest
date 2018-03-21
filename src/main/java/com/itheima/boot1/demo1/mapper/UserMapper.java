package com.itheima.boot1.demo1.mapper;

import com.itheima.boot1.demo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{
    @Select("select * from user")
    List<User> findAllUser();
}
