package com.start.entry.dao;

import com.start.entry.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserAnno {
    /* 查询操作*/
    //也可以写自己的实现类
    @Select("select * from user where id = 26")
    public List<User> findAllUser();
}
