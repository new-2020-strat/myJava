package com.dynamicSql.dao;



import com.dynamicSql.entity.User;

import java.util.List;

public interface IUser {
    /**
     * 根据User对象查询
     * @return
     */
    public List<User> selectUserByCondition(User user);

    /**
     * 根据id的集合查询foreach
     * @param list
     * @return
     */
    public  List<User> selectUserByIdList(List<Integer> list);


}
