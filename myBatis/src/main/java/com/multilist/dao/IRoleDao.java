package com.multilist.dao;

import com.multilist.entity.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectAllRole();

    /**
     * 查询当前角色并且带有该角色所属用户
     * @return
     */
    public List<Role> selectAllRoleWithUser();
}
