package com.crud.implDao.dao;

import com.crud.implDao.entity.User;

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
     * 查询一条
     * @param id
     * @return
     */
    public User selectOne(Integer id);
}
