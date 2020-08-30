package com.start.defineMybatis.dao;

import com.start.defineMybatis.entity.User;

import java.util.List;

public interface IUser {
    /* 查询操作*/
    public List<User> findAllUser();
}
