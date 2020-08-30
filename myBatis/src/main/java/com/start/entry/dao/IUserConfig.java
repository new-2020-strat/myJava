package com.start.entry.dao;

import com.start.entry.entity.User;

import java.util.List;

public interface IUserConfig {
    /* 查询操作*/
    //也可以写自己的实现类
    public List<User> findAllUser();
}
