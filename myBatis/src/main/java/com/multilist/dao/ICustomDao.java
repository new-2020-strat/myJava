package com.multilist.dao;

import com.multilist.entity.Customer;

import java.util.List;

public interface ICustomDao {
    /**
     * 查询所有用户并且带有该用户所属角色
     * @return
     */
    public List<Customer> selectAllCustomerWithRole();
}
