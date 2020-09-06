package com.anno.dao;

import com.anno.entity.UserDiff;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.util.List;

/**
 * 注解开发实体类和表字段不一致
 * 可以通过取别名解决，但是不推荐
 */
public interface IUserDaoDiff {
    /**
     * 查询所有
     */
    @Select("select * from user")
    @Results(id = "UserMap",value = {
        @Result(id = true,column = "id",property = "id_new"),
        @Result(column = "username",property = "userName_new"),
        @Result(column = "sex",property = "sex_new"),
        @Result(column = "birthday",property = "birthday_new"),
        @Result(column = "address",property = "address_new"),
    })
    public List<UserDiff> findAll();

    /**
     * 通过id出巡
     * @return
     */

    @Select("select * from user where id = #{id}")
    //@ResultMap(value = {"UserMap"})//当只有一个映射关系可以省略value
    @ResultMap("UserMap")
    public UserDiff findUserById(Integer id);

}
