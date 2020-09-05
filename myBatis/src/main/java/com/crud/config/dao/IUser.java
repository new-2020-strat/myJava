package com.crud.config.dao;

import com.crud.config.entity.User;
import com.crud.config.entity.Users;

import java.util.List;

public interface IUser {
    /**
     * 查询User表所有
     * @return
     */
    public List<User> selectAll();

    /**
     * 添加数据
     * @param user
     */
    public Integer insertUser(User user);

    /**
     * 更新数据
     * @param user
     * @return
     */
    public Integer updateUser(User user);

    /**
     *  删除操作(通过id删除)
     * @param id
     * @return
     */
    public Integer deleteUser(Integer id);
    /**
     * 模糊查询
     * @param username
     * @return
     */
    public List<User> queryByDim(String username);

    /**
     * OGNL表达式查询
     * @param users
     * @return
     */
    public  List<User> findUser(Users users);

    /**
     * 实体类与数据库列名不一致查询
     * @return
     */
    public List<User> findall();

}
