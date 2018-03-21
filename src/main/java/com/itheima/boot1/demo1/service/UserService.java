package com.itheima.boot1.demo1.service;

import com.itheima.boot1.demo1.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    List<User> getUserListByPage();
}
