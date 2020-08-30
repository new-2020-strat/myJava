package com.crud.config.dao;

import com.crud.config.entity.UserFieldDiff;

import java.util.List;

public interface IUserFieldDiff {

    /**
     * 查询所有(实体类和表中字段名不一致,取别名)
     * @return
     */
    public List<UserFieldDiff> selectAllUserNamed();
    /**
     * 查询所有(实体类和表中字段名不一致,建立映射关系)
     * @return
     */
    public List<UserFieldDiff> selectAllUserMap();


}
