package com.anno.dao;

import com.anno.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;

import java.util.List;

/**
 * 在mtbatis中有针对CRUD的四个注解
 * 分别是@SELECT,@INSERT,@UPDATE,@DELETE
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 插入数据
     */
    @Insert("insert into user(id,username,birthday,sex,address)" +
            "values(#{id},#{userName},#{birthday},#{sex},#{address})")
    public void insert(User user);

    /**
     * 更新修改操作
     */
    @Update("update user set username=#{userName} where id=#{id}")
    public void update(User user);

    /**
     * 删除
     */
    @Update("delete from user where id= #{id}")
    public void delete(Integer id);

    /**
     * 通过id查询一个
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findById(Integer id);

    /**
     * 用过名称模糊查询
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    List<User> findByName(String username);

    /**
     * 获取总记录数
     * @return
     */
    @Select("select count(*) from user")
    Integer getTotal();
}
