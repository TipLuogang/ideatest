package com.itheima.boot1.demo1.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.boot1.demo1.mapper.UserMapper;
import com.itheima.boot1.demo1.pojo.User;
import com.itheima.boot1.demo1.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "userCache", key = "'getAllUser'") //添加&使用缓存
    @Override
    public List<User> findAllUser() {
        System.out.println("缓存取值");
        return userMapper.findAllUser();
    }
    @CacheEvict(value = "userCache", key = "'getAllUser'") //删除缓存
    @Override
    public List<User> getUserListByPage() {
        System.out.println("清理缓存");
        PageHelper.startPage(1,2); //设置分页
        List<User> list = userMapper.select(null);
        Page<User> page = (Page<User>) list;
        //System.out.println("总记录数:" + page.getTotal());//9
       // System.out.println("总页数:" + page.getPages());//5

        PageInfo page2 = new PageInfo(list);
        page2.getTotal();
        page2.getPages();
        return list;
    }
}
