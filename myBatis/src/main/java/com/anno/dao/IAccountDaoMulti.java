package com.anno.dao;

import com.anno.entity.Account;
import com.anno.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 通过注解多表查询测试
 */
public interface IAccountDaoMulti {
    /**
     * 查询所有账户并且带有该账户所属用户信息
     */
    @Select("select * from account")
    @Results(value = {
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "uid",property = "uid"),
        @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select = "com.anno.dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    public List<Account> findAllAconutsWithUser();

    /**
     * 查询所有用户并且带有该用户所属账户信息
     */
    @Select("select * from user")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            @Result( property= "accounts",column = "id",many=@Many(select = "com.anno.dao.IAccountDao.findAccountById",fetchType = FetchType.LAZY))
    })
    public List<User> findAllUsersWithAccount();


}
