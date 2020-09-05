package com.multilist.dao;
import com.multilist.entity.User;
import java.util.List;

public interface IUserDao {
    /**
     * 查询User表所有
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 通过id查询
     * @return
     */
    public User selectById(Integer id);

    /**
     * 一对多，一个用户有多个账户的查询所有用户
     */
    public List<User> selectAllUserWithAllAccount();
}
