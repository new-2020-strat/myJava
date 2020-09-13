package com.transaction.anno.transferManager.dao;

import com.transaction.anno.transferManager.entity.Account;

//持久层接口
public interface IAccountDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Account findAccountById(Integer id);

    /**
     * 根据账号名称查询
     * @param accountName
     * @return
     */
    public Account findAccountByName(String accountName);

    /**
     * 更新用户
     * @param account
     */
    public void updateAccount(Account account);

}
